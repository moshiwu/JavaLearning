package com.company;

/**
 * 自定义线程 - 继承
 * Created by moqiaowen on 2017/5/17.
 */
public class Custom_Thread_By_Extends extends Thread {

    private String name;


    public Custom_Thread_By_Extends(String name) {
        super();
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(name + " : " + i);
        }

        super.run();
    }
}
