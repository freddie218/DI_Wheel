package com.huan.di.beans;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:30 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonTransportation implements Transportation {
    protected String name;
    protected double pricePreMiles;
    protected int speed;

    public CommonTransportation(){
        this.name = "default";
        this.pricePreMiles = 0;
        this.speed = 0;
    }

    public CommonTransportation(String name, double pricePreMiles, int speed) {
        this.name = name;
        this.pricePreMiles = pricePreMiles;
        this.speed = speed;
    }

    public String getName() {
        return name;
    }

    public double getPricePreMiles() {
        return pricePreMiles;
    }

    public int getSpeed() {
        return speed;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPricePreMiles(Double pricePreMiles) {
        this.pricePreMiles = pricePreMiles;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }
}
