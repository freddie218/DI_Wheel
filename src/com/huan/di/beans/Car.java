package com.huan.di.beans;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:41 AM
 * To change this template use File | Settings | File Templates.
 */
public class Car extends CommonTransportation {
    public Car(String name, double pricePreMile, int speed) {
        super(name, pricePreMile, speed);
    }

    public Car(){
        super("cross_polo", 2.0, 100);
    }
}
