package com.dental.config;

import com.dental.bean.InjectTextMessageBeanPostProcessor;
import com.dental.bean.ProfilerHandlerBeanPostProcessor;
import com.dental.test.PropertyEditorRun;
import com.dental.test.PropertyEditorRunEditor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.*;

import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by light on 1/6/2015.
 */

@Configuration
@ComponentScan(basePackages = "com.dental")
@Import({SpringConfig.class, DaoConfig.class, SpringSecureConfig.class, SwaggerConfig.class})
public class AppConfig {

//  @Bean(name = "testBean")
//  public SayText getSayText() {
//    return new TestBean();
//  }

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

}
