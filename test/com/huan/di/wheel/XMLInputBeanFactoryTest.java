package com.huan.di.wheel;

import com.huan.di.beans.Location;
import com.huan.di.beans.Transportation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLInputBeanFactoryTest {
    public XMLInputBeanFactory beanFactory;

    @Before
    public void init(){
        beanFactory = new XMLInputBeanFactory();
    }

    @Test
    public void shouldGotNullObjectWithEmptyString(){
        Transportation train = (Transportation) beanFactory.getSimpleBeanByBeanId("");
        assertThat(train, nullValue());
    }

    @Test
    public void shouldBeAbleToGetObjectByString(){
        String beanId = "train";
        Transportation train = (Transportation) beanFactory.getSimpleBeanByBeanId(beanId);

        assertThat(train, notNullValue());
        assertThat(train.getName(), is("Train"));
    }

    @Test
    public void shouldBeAbleToGetObjectConstructorInjector(){
        String beanId = "location";
        Location location = (Location) beanFactory.getBeanWithConstructorInjector(beanId);

        assertThat(location, notNullValue());
        assertThat(location.getName(), is("Dunhuang"));
    }

    @Test
    public void shouldBeAbleToGetObjectConstructorInjectorMoreThanOneParameters(){
        String beanId = "car";
        Transportation transportation = (Transportation) beanFactory.getBeanWithConstructorInjector(beanId);

        assertThat(transportation, notNullValue());
        assertThat(transportation.getName(), is("cross_polo"));
        assertThat(transportation.getPricePreMiles(), is(2.1));
        assertThat(transportation.getSpeed(), is(100));
    }

    @Test
    public void shouldBeAbleToGetObjectSetterInjector(){
        String beanId = "car2";
        Transportation transportation = (Transportation) beanFactory.getBeanWithSetterInjector(beanId);

        assertThat(transportation, notNullValue());
        assertThat(transportation.getName(), is("polo"));
        assertThat(transportation.getPricePreMiles(), is(2.4));
        assertThat(transportation.getSpeed(), is(100));
    }
}
