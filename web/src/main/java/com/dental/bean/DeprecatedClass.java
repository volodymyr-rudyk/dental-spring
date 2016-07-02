package com.dental.bean;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by vrudyk on 6/11/2016.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface DeprecatedClass {
  Class newImpl();
}
