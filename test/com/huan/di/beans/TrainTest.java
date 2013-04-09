package com.huan.di.beans;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:37 AM
 * To change this template use File | Settings | File Templates.
 */
public class TrainTest {
    public Transportation transportation;

    @Before
    public void init(){
        transportation = new Train("K1231", 1.3, 80);
    }

    @Test
    public void shouldHaveBasicPropertyForUse(){
        assertThat(transportation.getName(), is("K1231") );
        assertThat(transportation.getPricePreMiles(), is(1.3) );
        assertThat(transportation.getSpeed(), is(80) );
    }
}
