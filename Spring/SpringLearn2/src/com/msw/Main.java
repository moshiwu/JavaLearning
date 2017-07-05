package com.msw;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by moqiaowen on 2017/7/3.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("hello");

        BeanFactory factory = new ClassPathXmlApplicationContext("mainResource.xml");

        HelloWorld bean1 = (HelloWorld) factory.getBean("HelloWorldBeanDefault");
        bean1.sayHello();

        HelloWorld bean2 = (HelloWorld) factory.getBean("HelloWorldBeanWithConstructor");
        bean2.sayHello();

        HelloWorld bean3 = (HelloWorld) factory.getBean("HelloWorldBeanWithFactory");
        bean3.sayHello();

        Person person = (Person) factory.getBean("laowang");
        System.out.println(person);
    }
}
