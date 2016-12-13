package com.dntistpro.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;

/**
 * Created by vrudyk on 3/21/2016.
 */
public class InjectTextMessageBeanPostProcessor implements BeanPostProcessor {
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
    Field[] declaredFields = bean.getClass().getDeclaredFields();
    for (Field field : declaredFields) {
      InjectTextMessage annotation = field.getAnnotation(InjectTextMessage.class);
      if (annotation != null) {
        String value = annotation.value();
        field.setAccessible(true);
        ReflectionUtils.setField(field, bean, value);
      }
    }

    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
