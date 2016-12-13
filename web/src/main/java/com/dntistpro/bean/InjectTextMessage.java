package com.dntistpro.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by vrudyk on 3/21/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectTextMessage {
  String value();
}
