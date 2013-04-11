package com.huan.di.wheel;

import com.huan.di.beans.Location;
import com.huan.di.beans.Transportation;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLInputBeanFactoryTest {
    public BeanFactory beanFactory;

    @Before
    public void init(){
        beanFactory = new XMLInputBeanFactory();
    }

    @Test
    public void shouldGotNullObjectWithEmptyString(){
        Transportation train = (Transportation) beanFactory.getSimpleBean("");
        assertThat(train, nullValue());
    }

    @Test
    public void shouldBeAbleToGetObjectByString(){
        String beanId = "train";
        Transportation train = (Transportation) beanFactory.getSimpleBean(beanId);

        assertThat(train, notNullValue());
        assertThat(train.getName(), is("Train"));
    }

    @Test
    public void shouldBeAbleToGetObjectWithParameter(){
        String className = "com.huan.di.beans.Location";
        Class[] initTypes = new Class[]{String.class};
        Object[] inits = new Object[]{"Xian"};
        Location location = (Location) beanFactory.getBeanWithParam(className, initTypes, inits);

        assertThat(location, notNullValue());
        assertThat(location.getName(), is("Xian"));
    }

    @Test
    public void shouldBeAbleToGetClassMoreThanOneParameters(){
        String className = "com.huan.di.beans.Car";
        Class[] initTypes = new Class[]{String.class, double.class, int.class};
        Object[] inits = new Object[]{"cross_polo", 2.0, 100};
        Transportation transportation = (Transportation) beanFactory.getBeanWithParam(className, initTypes, inits);

        assertThat(transportation, notNullValue());
        assertThat(transportation.getName(), is("cross_polo"));
        assertThat(transportation.getPricePreMiles(), is(2.0));
        assertThat(transportation.getSpeed(), is(100));
    }

    @Test
    public void shouldCreateObjectBySetters(){
        String className = "com.huan.di.beans.Car";
        Map<String, Object> setterParams = new HashMap<String, Object>();
        setterParams.put("name", "polo");
        setterParams.put("pricePreMiles", 2.0);
        setterParams.put("speed", 100);

        Transportation transportation = (Transportation) beanFactory.getBeanBySetter(className, setterParams);

        assertThat(transportation, notNullValue());
        assertThat(transportation.getName(), is("polo"));
        assertThat(transportation.getPricePreMiles(), is(2.0));
        assertThat(transportation.getSpeed(), is(100));
    }
}
