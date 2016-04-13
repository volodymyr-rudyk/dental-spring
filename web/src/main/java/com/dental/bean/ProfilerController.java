package com.dental.bean;

/**
 * Created by vrudyk on 3/31/2016.
 */
public class ProfilerController implements ProfilerControllerMBean {
  private boolean enabled;

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }
}
