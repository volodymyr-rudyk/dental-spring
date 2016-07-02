package com.dental.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

/**
 * Created by vrudyk on 6/11/2016.
 */
@Component
public class DeprecationFactoryBeanPostProcessor implements BeanFactoryPostProcessor {
  @Override
  public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
    String[] beanDefinitionNames = beanFactory.getBeanDefinitionNames();
    for (String beanDefinitionName : beanDefinitionNames) {
      BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanDefinitionName);
      String beanClassName = beanDefinition.getBeanClassName();
      try {
        if (beanClassName == null) {
          continue;
        }
        Class<?> beanClass = Class.forName(beanClassName);
        DeprecatedClass annotation = beanClass.getAnnotation(DeprecatedClass.class);
        if (annotation != null) {
          beanDefinition.setBeanClassName(annotation.newImpl().getName());
        }
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }

    }
  }
}
