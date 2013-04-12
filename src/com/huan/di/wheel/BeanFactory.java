package com.huan.di.wheel;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/10/13
 * Time: 6:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface BeanFactory {
    Object getSimpleBean(String className);

    Object getBeanWithParam(String className, Class[] initTypes, Object[] inits);

    Object getBeanBySetter(String className, Map<String, Object> setterParams);

}
