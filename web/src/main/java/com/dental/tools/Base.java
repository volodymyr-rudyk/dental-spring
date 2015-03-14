package com.dental.tools;

/**
 * Created by light on 1/7/2015.
 */
public class Base {

    private int i = 5;


    public Base() {
        System.out.println("Base constructor " + this.getI());
    }

    public int getI(){
        System.out.println("Base getI " + i);

        return i;
    }

}
