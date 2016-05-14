package com.dental.config;

import com.dental.bean.InjectTextMessageBeanPostProcessor;
import com.dental.bean.ProfilerHandlerBeanPostProcessor;
import com.dental.bean.SayText;
import com.dental.bean.TestBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@ComponentScan(basePackages = "com.dental")
@Import({SpringConfig.class, DaoConfig.class, SpringSecureConfig.class})
public class AppConfig {

  @Bean(name = "testBean")
  public SayText getSayText() {
    return new TestBean();
  }

  @Bean
  public BeanPostProcessor sayTextProcessor() {
    return new InjectTextMessageBeanPostProcessor();
  }

  @Bean
  public BeanPostProcessor commonAnnotationBeanPostProcessor() {
    return new CommonAnnotationBeanPostProcessor();
  }

  @Bean
  public BeanPostProcessor profilerHandlerBeanPostProcessor() throws Exception {
    return new ProfilerHandlerBeanPostProcessor();
  }



}
