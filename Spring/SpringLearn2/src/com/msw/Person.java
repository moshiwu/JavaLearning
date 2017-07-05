package com.msw;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by moqiaowen on 2017/7/3.
 */


public class Person {

    public Car car;
    public String name;

//    public Person(String name, Car car) {
//        this.name = name;
//        this.car = car;
//
//    }

    @Autowired

    public Person(String name) {
        this.name = name;
        System.out.println("init person with name " + name);
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "person " + this.name + "has a car : " + car;
    }
}
