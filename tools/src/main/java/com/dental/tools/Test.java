package com.dental.tools;

/**
 * Created by light on 1/7/2015.
 */
public class Test extends Base {


  private static int i = 10;

  public Test() {
    System.out.println("Test constructor " + super.getI());
  }

  public static void main(String[] args) {
    Test test = new Test();
  }

  public int getI() {
    System.out.println("Test getI " + i);

    return i;
  }
}
