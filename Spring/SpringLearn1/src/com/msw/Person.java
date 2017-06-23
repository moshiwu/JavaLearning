package com.msw;

/**
 * Created by moqiaowen on 2017/6/23.
 */
public class Person {
    private IHelloMessage helloMessage;

    public IHelloMessage getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(IHelloMessage helloMessage) {
        this.helloMessage = helloMessage;
    }

    public void sayHello() {
        this.helloMessage.sayHello();
    }
}
