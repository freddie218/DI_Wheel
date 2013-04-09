package com.huan.di.beans;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 1:39 PM
 * To change this template use File | Settings | File Templates.
 */
public class Route {
    private Location startLocation;
    private Location endLocation;
    private int length;

    public Route(Location startLocation, Location endLocation, int length) {
        this.startLocation = startLocation;
        this.endLocation = endLocation;
        this.length = length;
    }


    public int travelLength() {
        return this.length;
    }

    public String startLocation() {
        return startLocation.getName();
    }

    public String endLocation() {
        return endLocation.getName();
    }
}
