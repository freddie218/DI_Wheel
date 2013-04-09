package com.huan.di.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 2:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Travel {
    private List<Route> routeList = new ArrayList<Route>();
    private Transportation transportation;

    public Travel(Transportation transportation) {
        this.transportation = transportation;
    }

    public Travel() {
        super();
    }

    public void addRoute(Route route) {
        routeList.add(route);
    }

    public int routeTotal() {
        return this.routeList.size();
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public double transportationCost() {
        return totalTravelLength() * transportation.getPricePreMiles();
    }

    public double transportationDuration() {
        return totalTravelLength() / (double)transportation.getSpeed();
    }

    private int totalTravelLength() {
        int length = 0;
        for (Route route : routeList) {
            length += route.travelLength();
        }
        return length;
    }
}
