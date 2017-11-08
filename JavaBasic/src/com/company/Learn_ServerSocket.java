package com.company;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.nio.Buffer;
import java.util.Vector;

/**
 * Created by moqiaowen on 2017/5/18.
 */
public class Learn_ServerSocket {

    public static void main(String[] args) {

        new ServerSocketListener().start();

    }

}


class ServerSocketListener extends Thread {

    @Override
    public void run() {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); //端口为 1 - 65535


            //线程run方法运行完毕之后，线程就结束了，并不符合设计要求，所以这里用while循环形成runloop
            while (true) {
                Socket socket = serverSocket.accept();
                SocketConnection connection = new SocketConnection(socket);
                connection.start();

                SocketConnectionManager.getInstance().add(connection);
                System.out.println("有人连接到本端口");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class SocketConnection extends Thread {
    Socket socket;

    public SocketConnection(Socket socket) throws SocketException {
        this.socket = socket;
//        this.socket.setKeepAlive(true);
//        this.socket.setSoTimeout(1000);
    }

    public Boolean isServerClose() {
        try {

            //这里一旦发送紧急包，就会导致无法正常发送数据，目前未知什么原因，以后待查
//            socket.sendUrgentData(0);//发送1个字节的紧急数据，默认情况下，服务器端没有开启紧急数据处理，不影响正常通信

            return false;
        } catch (Exception se) {
            return true;
        }
    }

    public void out(String message) throws IOException {
        System.out.println("out : " + message + this);


//        方式一
//        this.socket.getOutputStream().write(message.getBytes("UTF-8"));


        //方式 二
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
        writer.println(message);
    }

    @Override
    public void run() {


        try {

//            int count = 0;
//            while (true) {
//                String str = "loop " + count + "";
//
//                count++;
//                if (isServerClose()) {
//                    System.out.println("service close");
//                    this.socket.close();
//                    break;
//                } else {
//                    System.out.println("service alive");
//                    //方式一
////                    this.socket.getOutputStream().write(str.getBytes("UTF-8"));
//
//                    //方式二
//                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
//                    out.println(str);
//
//                }
//              }

            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream(), "UTF-8");
            BufferedReader reader = new BufferedReader(streamReader);

            String line = null;

            //死循环不停读取
            while ((line = reader.readLine()) != null) {

                //如果publish出错，会抛出异常，跳出循环
                SocketConnectionManager.getInstance().publish(this, line);
                sleep(500);
            }

            reader.close();
            streamReader.close();

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                System.out.println("Socket close");
                this.socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            this.socket = null;
        }


    }
}

class SocketConnectionManager {
    private static SocketConnectionManager instance = null;

    public static SocketConnectionManager getInstance() {
        if (instance == null) {
            synchronized ("lock") {
                instance = new SocketConnectionManager();
            }
        }
        return instance;
    }

    private Vector<SocketConnection> connections = new Vector<SocketConnection>();

    public void add(SocketConnection connection) {
        connections.add(connection);
    }

    public void remove(SocketConnection connection) {
        connections.removeElement(connection);
    }

    public void publish(SocketConnection selfConnection, String message) throws IOException {
        for (int i = 0; i < connections.size(); i++) {
            SocketConnection connect = connections.get(i);

            if (connect != selfConnection) {
                connect.out(message);
            }

            System.out.println(connect + " " + selfConnection);
            System.out.println(connect == selfConnection);

        }
        System.out.println("-------");

    }

}