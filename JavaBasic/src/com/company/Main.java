package com.company;


interface Engine {
    public void start();

    public void stop();
}


interface Wing {
    public void swayUp();

    public void swayDown();
}


class Plane implements Engine, Wing {

    String name = "none";


    public String getName() {
        System.out.println("get name");
        return name;
    }

    public void setName(String name) {
        System.out.println("set name");
        this.name = name;
    }


    public void start() {
        System.out.println("engine start");
    }

    public void stop() {

        System.out.println("engine stop");
    }


    public void swayUp() {
        System.out.println("wing sway up");
    }


    public void swayDown() {
        System.out.println("wing sway down");
    }
}


public class Main {

    public static void main(String[] args) {
        // write your code here

        Plane p1 = new Plane();

        p1.start();
        p1.stop();

        Plane p2 = new Plane() {
            @Override
            public void start() {
                System.out.println("override engine start");
            }
        };

        p2.start();

        String name = p1.name;
        p1.name = "9527";


        //通过继承来自定义线程
//        customThreadByExtends();

        //通过接口Runnable来实现自定义线程
//        customThreadByRunable();
    }


    public static void customThreadByExtends() {
        Custom_Thread_By_Extends t1 = new Custom_Thread_By_Extends("Thread A");
        Custom_Thread_By_Extends t2 = new Custom_Thread_By_Extends("Thread B");

        //线程的启动不是通过run方法来启动，否则就跟直接调用run方法一样
//        t1.run();
//        t2.run();

        t1.start();
        t2.start();
    }

    public static void customThreadByRunable() {
        Custom_Thread_By_Runnable r3 = new Custom_Thread_By_Runnable("Thread C");
        Custom_Thread_By_Runnable r4 = new Custom_Thread_By_Runnable("Thread D");

        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);

        t3.start();
        t4.start();
    }
}

