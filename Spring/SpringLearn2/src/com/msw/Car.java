package com.msw;

import javax.sound.midi.Soundbank;

/**
 * Created by moqiaowen on 2017/7/3.
 */
public class Car {

    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car(String name) {
        this.name = name;
        System.out.println("init car with name " + name);
    }
}
