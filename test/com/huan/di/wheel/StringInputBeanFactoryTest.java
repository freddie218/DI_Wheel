package com.huan.di.wheel;

import com.huan.di.beans.Transportation;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/10/13
 * Time: 6:29 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringInputBeanFactoryTest {

    public BeanFactory beanFactory;

    @Before
    public void init(){
        beanFactory = new StringInputBeanFactory();
    }

    @Test
    public void shouldGotNullObjectWithEmptyString(){
        Transportation train = (Transportation) beanFactory.getSimpleBean("");
        assertThat(train, nullValue());
    }

    @Test
    public void shouldBeAbleToGetObjectByString(){
        String className = "com.huan.di.beans.Train";
        Transportation train = (Transportation) beanFactory.getSimpleBean(className);

        assertThat(train, notNullValue());
        assertThat(train.getName(), is("Train"));
    }
}
