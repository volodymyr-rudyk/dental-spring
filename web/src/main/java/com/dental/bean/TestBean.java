package com.dental.bean;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * Created by vrudyk on 3/21/2016.
 */
@Component
@Profiler
@DeprecatedClass(newImpl = TestBeanNew.class)
public class TestBean implements SayText{

  @InjectTextMessage(value = "hi its me.")
  private String text;

  @PostConstruct
  public void init() {
    System.out.println("init");
  }

  @Override
  @Profiler
  public void sayText() {
    System.out.println("text from annotation = " + text);

  }
}
