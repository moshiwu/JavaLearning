package com.msw;

/**
 * Created by moqiaowen on 2017/7/3.
 */
public class HelloWorld implements IHelloWorld {
    protected String message;

    public HelloWorld() {
        this.message = "default message";
    }

    public HelloWorld(String message) {
        this.message = message;
    }

    public static HelloWorld newInstance(String message) {
        return new HelloWorld(message);
    }



    @Override
    public void sayHello() {
        System.out.println(this.message);
    }


}
