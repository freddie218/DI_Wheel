package com.huan.di.beans;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:52 AM
 * To change this template use File | Settings | File Templates.
 */
public class RouteTest {
    public Location startLocation, endLocation;
    public Route route;

    @Before
    public void init(){
        startLocation = new Location("xian");
        endLocation = new Location("lanzhou");
        route = new Route(startLocation, endLocation, 647);
    }

    @Test
    public void shouldHaveLocationName(){
        assertThat(route.startLocation(), is("xian") );
        assertThat(route.endLocation(), is("lanzhou") );
        assertThat(route.travelLength(), is(647) );
    }
}
