package com.huan.di.wheel;

import org.dom4j.Document;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: twer
 * Date: 4/11/13
 * Time: 9:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class XMLFileReaderTest {
    public XMLFileReader xmlFileReader;
    public Document document;

    @Before
    public void init(){
        String file = "./resources/wheel_config.xml";
        xmlFileReader = new XMLFileReader(file);
        document = xmlFileReader.getDocument();
    }

    @Test
    public void shouldReadTheFile(){
        assertThat(document, notNullValue());
        assertThat(document.getRootElement().getName(), is("wheels"));
    }

    @Test
    public void shouldAllBeansConfigedInFile(){
        assertThat(xmlFileReader.nodeSize(), is(3));
    }

    @Test
    public void shouldHaveNodesWithName(){
        List nodeList = xmlFileReader.nodeList("wheel");
        assertThat(nodeList.size(), is(3));
    }
}
