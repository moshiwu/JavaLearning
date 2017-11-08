package com.company;

/**
 * 自定义线程 - 协议
 * Created by moqiaowen on 2017/5/17.
 */
public class Custom_Thread_By_Runnable implements Runnable {

    private String name;

    public Custom_Thread_By_Runnable(String name) {
        this.name = name;
    }

    @Override
    public void run() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(name + " : " + i);
        }
    }
}
