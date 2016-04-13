package com.dental.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import java.lang.management.ManagementFactory;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by vrudyk on 3/29/2016.
 */
public class ProfilerHandlerBeanPostProcessor implements BeanPostProcessor {

  private Map<String, Class> classMap = new HashMap<>();
  private ProfilerController profilerController = new ProfilerController();

  public ProfilerHandlerBeanPostProcessor() throws Exception {
    MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
    mBeanServer.registerMBean(profilerController, new ObjectName("profiling", "name", "controller"));
  }

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Class<?> beanClass = bean.getClass();
    if (beanClass.isAnnotationPresent(Profiler.class)) {
      classMap.put(beanName, beanClass);
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    Class beanClass = classMap.get(beanName);
    if (beanClass != null) {
      Proxy.newProxyInstance(beanClass.getClassLoader(), beanClass.getInterfaces(), new InvocationHandler() {
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
          if (profilerController.isEnabled()){
            System.out.println("Profiling ...");
            long before = System.nanoTime();
            Object result = method.invoke(o, objects);
            System.out.println("Profiling Done in " + String.valueOf(System.nanoTime() - before));
            return result;
          }
          return method.invoke(o, objects);
        }
      });
    }

    return bean;
  }
}
