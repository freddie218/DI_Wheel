package com.huan.di.beans;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
public class TravelTest {
    public Travel travel;
    public Route route1, route2, route3, route4;
    private Location xian;
    private Location lanzhou;
    private Location zhangye;
    private Location dunhuang;

    @Before
    public void init(){
        travel = new Travel();
        xian = new Location("xian");
        lanzhou = new Location("lanzhou");
        zhangye = new Location("zhangye");
        dunhuang = new Location("dunhuang");
        route1 = new Route(xian, lanzhou, 647);
        route2 = new Route(lanzhou, zhangye, 511);
        route3 = new Route(zhangye, dunhuang, 594);
        route4 = new Route(dunhuang, xian, 1730);
    }

    @Test
    public void shouldBeAbleToAddRoutes(){
        travel.addRoute(route1);
        travel.addRoute(route2);
        travel.addRoute(route3);
        travel.addRoute(route4);
        assertThat(travel.routeTotal(), is(4));
    }

    @Test
    public void shouldHaveTransportationWhenCreate() {
        travel = new Travel(new Train());
        assertThat(travel.getTransportation(), notNullValue());
    }

    @Test
    public void shouldBeAbleToSetTransportation(){
        travel.setTransportation(new Car());
        assertThat(travel.getTransportation(), notNullValue());
    }

    @Test
    public void shouldCalculateTransportationCost(){
        travel = new Travel(new Train());
        travel.addRoute(route1);
        travel.addRoute(route2);
        travel.addRoute(route3);
        travel.addRoute(route4);
        assertThat(travel.transportationCost(), is(766.04));
    }

    @Test
    public void shouldCalculateTransportationDuration(){
        travel = new Travel(new Train());
        travel.addRoute(route1);
        travel.addRoute(route2);
        travel.addRoute(route3);
        travel.addRoute(route4);
        assertThat(travel.transportationDuration(), is(43.525));
    }
}
