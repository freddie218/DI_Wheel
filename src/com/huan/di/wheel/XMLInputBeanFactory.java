package com.huan.di.wheel;

import org.dom4j.Element;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLInputBeanFactory extends StringInputBeanFactory {
    XMLFileReader xmlFileReader = new XMLFileReader("./resources/wheel_config.xml");

    public Object getSimpleBeanByBeanId(String beanId) {
        if (null == beanId || beanId.isEmpty()) return null;

        List beanList = xmlFileReader.nodeList("wheel");
        for (Object element : beanList) {
            String id = ((Element)element).attribute("id").getValue();
            if (id.equals(beanId)) {
                String className = ((Element)element).attribute("class").getValue();
                return getSimpleBean(className);
            }
        }

        return null;
    }

    public Object getBeanWithConstructorInjector(String beanId) {
        if (null == beanId || beanId.isEmpty()) return null;

        List beanList = xmlFileReader.nodeList("wheel");
        for (Object element : beanList) {
            String id = ((Element)element).attribute("id").getValue();
            if (id.equals(beanId)) {
                String className = ((Element)element).attribute("class").getValue();

                List<Element> elementList = ((Element) element).elements("constructor-arg");
                int paramCount = elementList.size();

                if (paramCount <= 0) return null;

                Class[] initTypes = new Class[paramCount];
                Object[] inits = new Object[paramCount];

                for (int i=0; i<paramCount; i++) {
                    String type = elementList.get(i).attribute("type").getValue();

                    if ("Integer".equals(type) || "int".equals(type)) {
                        initTypes[i] = int.class;
                        inits[i] = Integer.valueOf(elementList.get(i).attribute("value").getValue());
                    } else if ("Double".equals(type) || "double".equals(type)) {
                        initTypes[i] = double.class;
                        inits[i] = Double.valueOf(elementList.get(i).attribute("value").getValue());
                    } else if ("Float".equals(type) || "float".equals(type)) {
                        initTypes[i] = float.class;
                        inits[i] = Float.valueOf(elementList.get(i).attribute("value").getValue());
                    } else if ("Char".equals(type) || "char".equals(type)) {
                        initTypes[i] = char.class;
                        inits[i] = elementList.get(i).attribute("value").getValue().charAt(0);
                    } else {
                        initTypes[i] = type.getClass();
                        inits[i] = elementList.get(i).attribute("value").getValue();
                    }
                }

                return getBeanWithParam(className, initTypes, inits);
            }
        }

        return null;
    }

    public Object getBeanWithSetterInjector(String beanId) {
        if (null == beanId || beanId.isEmpty()) return null;

        List beanList = xmlFileReader.nodeList("wheel");
        for (Object element : beanList) {
            String id = ((Element)element).attribute("id").getValue();
            if (id.equals(beanId)) {
                String className = ((Element)element).attribute("class").getValue();

                List<Element> elementList = ((Element) element).elements("setter-arg");
                int paramCount = elementList.size();

                if (paramCount <= 0) return null;

                Map<String, Object> settersMap = new HashMap<String, Object>();

                for (int i=0; i<paramCount; i++) {
                    String type = elementList.get(i).attribute("type").getValue();

                    if ("Integer".equals(type) || "int".equals(type)) {
                        settersMap.put(elementList.get(i).attribute("name").getValue(), Integer.valueOf(elementList.get(i).attribute("value").getValue()));
                    } else if ("Double".equals(type) || "double".equals(type)) {
                        settersMap.put(elementList.get(i).attribute("name").getValue(), Double.valueOf(elementList.get(i).attribute("value").getValue()));
                    } else if ("Float".equals(type) || "float".equals(type)) {
                        settersMap.put(elementList.get(i).attribute("name").getValue(), Float.valueOf(elementList.get(i).attribute("value").getValue()));
                    } else if ("Char".equals(type) || "char".equals(type)) {
                        settersMap.put(elementList.get(i).attribute("name").getValue(), elementList.get(i).attribute("value").getValue().charAt(0));
                    } else {
                        settersMap.put(elementList.get(i).attribute("name").getValue(), elementList.get(i).attribute("value").getValue());
                    }
                }

                return getBeanBySetter(className, settersMap);
            }
        }

        return null;
    }
}
