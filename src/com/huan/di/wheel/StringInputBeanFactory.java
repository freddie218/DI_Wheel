package com.huan.di.wheel;

import com.sun.xml.internal.ws.util.StringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import static com.huan.di.util.LocalLogger.log;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/10/13
 * Time: 6:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringInputBeanFactory implements BeanFactory {

    @Override
    public Object getSimpleBean(String className) {
        if (stringClassNameVerifier(className)) return null;

        try {
            Class clazz = Class.forName(className);
            return clazz.newInstance();

        } catch (ClassNotFoundException e) {
            log("class not found for given string!");
        } catch (InstantiationException e) {
            log("can't init object for class: " + className);
        } catch (IllegalAccessException e) {
            log("can't access for for class: " + className);
        }

        return null;
    }

    @Override
    public Object getBeanWithParam(String className, Class[] initTypes, Object[] inits) {
        if (stringClassNameVerifier(className)) return null;

        try {
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getDeclaredConstructor(initTypes);

            return constructor.newInstance(inits);

        } catch (ClassNotFoundException e) {
            log("class not found for given string!");
        } catch (InstantiationException e) {
            log("can't init object for class: " + className);
        } catch (IllegalAccessException e) {
            log("can't access for class: " + className);
        } catch (InvocationTargetException e) {
            log("can't invocation for class: " + className);
        } catch (NoSuchMethodException e) {
            log("can't init for class with param: " + className);
        }

        return null;
    }

    @Override
    public Object getBeanBySetter(String className, Map<String, Object> setterParams) {
        if (stringClassNameVerifier(className)) return null;

        try {
            Class clazz = Class.forName(className);
            Object obj = clazz.newInstance();

            for (String name : setterParams.keySet()) {
                Method method = clazz.getMethod("set" + StringUtils.capitalize(name), setterParams.get(name).getClass());
                method.invoke(obj, setterParams.get(name));
            }

            return obj;

        } catch (ClassNotFoundException e) {
            log("class not found for given string!");
        } catch (InstantiationException e) {
            log("can't init object for class: " + className);
        } catch (IllegalAccessException e) {
            log("can't access for class: " + className);
        } catch (InvocationTargetException e) {
            log("can't invocation for class: " + className);
        } catch (NoSuchMethodException e) {
            log("can't init for class with param: " + className);
        }

        return null;
    }

    private boolean stringClassNameVerifier(String className) {
        if (null == className || className.isEmpty()) return true;
        return false;
    }

}
