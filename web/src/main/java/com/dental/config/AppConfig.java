package com.dental.config;

import com.dental.bean.InjectTextMessageBeanPostProcessor;
import com.dental.bean.ProfilerHandlerBeanPostProcessor;
import com.dental.bean.SayText;
import com.dental.bean.TestBean;
import com.dental.service.AuthService;
import com.dental.service.DentistService;
import com.dental.service.PatientService;
import com.dental.service.impl.AuthServiceImpl;
import com.dental.service.impl.DentistServiceImpl;
import com.dental.service.impl.PatientServiceImpl;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.*;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@ComponentScan(basePackages = "com.dental")
@Import({SpringConfig.class, DaoConfig.class, SpringSecureConfig.class})
public class AppConfig {

//  @Bean
//  public AuthService authService() {
//    return new AuthServiceImpl();
//  }
//
//  @Bean
//  public PatientService patientService() {
//    return new PatientServiceImpl();
//  }
//
//  @Bean
//  public DentistService dentistService() {
//    return new DentistServiceImpl();
//  }

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
