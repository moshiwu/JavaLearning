package com.msw;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by moqiaowen on 2017/6/23.
 */
public class Main {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("helloMessage.xml");
        Person person = (Person)factory.getBean("person");

        person.sayHello();
    }
}
