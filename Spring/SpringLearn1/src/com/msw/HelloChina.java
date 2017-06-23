package com.msw;

/**
 * Created by moqiaowen on 2017/6/23.
 */
public class HelloChina implements IHelloMessage {
    @Override
    public void sayHello() {
        System.out.println("世界你好");
    }
}
