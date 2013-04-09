package com.huan.di.beans;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/9/13
 * Time: 11:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocationTest {
    public Location location;

    @Before
    public void init(){
        location = new Location("xian");
    }

    @Test
    public void shouldHaveLocationName(){
        assertThat(location.getName(), is("xian") );
    }
}
