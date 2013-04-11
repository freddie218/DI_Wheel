package com.huan.di.wheel;

import org.dom4j.Element;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 10:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLInputBeanFactory implements BeanFactory {
    XMLFileReader xmlFileReader = new XMLFileReader("./resources/wheel_config.xml");

    @Override
    public Object getSimpleBean(String beanName) {
        if (null == beanName || beanName.isEmpty()) return null;

        List beanList = xmlFileReader.nodeList("wheel");
        for (Object element : beanList) {
            String beanId = ((Element)element).attribute("id").getValue();
            if (beanId.equals(beanName)) {
                String className = ((Element)element).attribute("class").getValue();
                StringInputBeanFactory stringInputBeanFactory = new StringInputBeanFactory();
                return stringInputBeanFactory.getSimpleBean(className);
            }
        }

        return null;
    }

    @Override
    public Object getBeanWithParam(String className, Class[] initTypes, Object[] inits) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object getBeanBySetter(String className, Map<String, Object> setterParams) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
