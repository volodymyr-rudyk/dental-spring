package com.dental.bean;

import javax.annotation.PostConstruct;

/**
 * Created by vrudyk on 6/11/2016.
 */
public class TestBeanNew extends TestBean implements SayText{

  @PostConstruct
  public void post() {
    System.out.println("post construct new bean");
  }

  @Override
  public void sayText() {
    System.out.println("Test Bean New");
  }
}
