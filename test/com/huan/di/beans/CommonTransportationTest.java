package com.huan.di.beans;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:29 AM
 * To change this template use File | Settings | File Templates.
 */
public class CommonTransportationTest {
    public Transportation transportation;

    @Before
    public void init(){
        transportation = new CommonTransportation("polo", 2.0, 100);
    }

    @Test
    public void shouldHaveBasicPropertyForUse(){
        assertThat(transportation.getName(), is("polo") );
        assertThat(transportation.getPricePreMiles(), is(2.0) );
        assertThat(transportation.getSpeed(), is(100) );
    }

}
