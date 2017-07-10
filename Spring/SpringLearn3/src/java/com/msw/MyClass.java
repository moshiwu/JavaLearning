package com.msw;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.tree.ConfigurationNode;
import org.springframework.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URL;
import java.util.List;

/**
 * Created by moqiaowen on 2017/7/6.
 */
@MyAnnotation(name = "annotation class name", age = 11)
public class MyClass {

    @MyAnnotation(name = "annotation method name", age = 30)
    public String getName(HttpServletRequest request, HttpServletResponse response) throws ConfigurationException {

        String path = this.getClass().getClassLoader().getResource("").getPath() + "../myBeans.xml";
        System.out.println("path : " + path);


        XMLConfiguration xc = new XMLConfiguration();
        xc.load(path);

        ConfigurationNode root = xc.getRootNode();

        List<ConfigurationNode> list =  root.getChildren("bean");



        for (ConfigurationNode n : list) {
            System.out.println("list : " +  n.getAttribute(0).getName().toString());
        }


        return "MyClassName";
    }

    public String getMe() {
        return "MyClass";
    }
}
