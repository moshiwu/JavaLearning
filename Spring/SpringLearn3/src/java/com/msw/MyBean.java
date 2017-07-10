package com.msw;

/**
 * Created by moqiaowen on 2017/7/5.
 */
public class MyBean {
    private String name;
    private int age;

    public MyBean() {
        System.out.println("com.msw.MyBean init");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
