package com.huan.di.beans;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class TravelAgency {

    public static void main(String[] args) {

        Travel travel = new Travel(new Train());

        Location xian = new Location("xian");
        Location lanzhou = new Location("lanzhou");
        Location zhangye = new Location("zhangye");
        Location dunhuang = new Location("dunhuang");

        travel.addRoute(new Route(xian, lanzhou, 647));
        travel.addRoute(new Route(lanzhou, zhangye, 511));
        travel.addRoute(new Route(zhangye, dunhuang, 594));
        travel.addRoute(new Route(dunhuang, xian, 1730));

        double cost = travel.transportationCost();
        System.out.print("totla travel cost is: " + cost);
    }
}
