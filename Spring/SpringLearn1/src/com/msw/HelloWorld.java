package com.msw;

/**
 * Created by moqiaowen on 2017/6/23.
 */
public class HelloWorld implements IHelloMessage {
    @Override
    public void sayHello() {
        System.out.println("Hello World");
    }
}
