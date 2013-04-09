package com.huan.di.beans;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:38 AM
 * To change this template use File | Settings | File Templates.
 */
public class Train extends CommonTransportation {
    public Train(String name, double pricePreMile, int speed) {
        super(name, pricePreMile, speed);
    }

    public Train() {
        super("Train", 0.22, 80);
    }
}
