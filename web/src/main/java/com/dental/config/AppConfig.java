package com.dental.config;

import com.dental.bean.InjectTextMessageBeanPostProcessor;
import com.dental.bean.ProfilerHandlerBeanPostProcessor;
import com.dental.test.PropertyEditorRun;
import com.dental.test.PropertyEditorRunEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@ComponentScan(basePackages = "com.dental")
@PropertySource(value = {"classpath:app.properties"})
@Import({SpringConfig.class, DaoConfig.class, SpringSecureConfig.class, SwaggerConfig.class})
public class AppConfig {

//  @Bean(name = "testBean")
//  public SayText getSayText() {
//    return new TestBean();
//  }

  @Autowired
  private Environment environment;

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

  public CustomEditorConfigurer customEditorConfigurer() {
    CustomEditorConfigurer customEditorConfigurer = new CustomEditorConfigurer();

    Map<Class<?>, Class<? extends PropertyEditor>> map = new HashMap<>();
    map.put(PropertyEditorRun.class, PropertyEditorRunEditor.class);
    customEditorConfigurer.setCustomEditors(map);

    return customEditorConfigurer;
  }

  @Bean
  public JavaMailSender javaMailSender() {
    JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
    javaMailSender.setHost(environment.getRequiredProperty("email.smtp.server"));
    return javaMailSender;
  }


}
