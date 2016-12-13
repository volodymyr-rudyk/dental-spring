package com.dntistpro.test;

import java.beans.PropertyEditorSupport;

/**
 * Created by vrudyk on 8/22/2016.
 */
public class PropertyEditorRunEditor extends PropertyEditorSupport {

  @Override
  public void setAsText(String text) throws IllegalArgumentException {
    PropertyEditorRun propertyEditorRun = new PropertyEditorRun();
    String[] split = text.split(" ");
    propertyEditorRun.setData(split[0]);
    propertyEditorRun.setI(Integer.parseInt(split[1]));
    setValue(propertyEditorRun);
  }
}
