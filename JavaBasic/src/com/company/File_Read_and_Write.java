package com.company;

import org.apache.commons.io.FileUtils;

import javax.sound.midi.Soundbank;
import java.io.*;

/**
 * 文件读写
 * Created by moqiaowen on 2017/5/15.
 */

public class File_Read_and_Write {

    public static void main(String[] args) throws IOException {
        // write your code here

        System.out.println("测试");

        File file = new File("text.txt");

        System.out.println(file.getAbsolutePath());
        System.out.println(file.exists());

        //读取
        if (file.exists()) {
            try {

                FileInputStream stream = new FileInputStream(file);
                InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
                BufferedReader bufferedReader = new BufferedReader(reader);


                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }

                bufferedReader.close();
                reader.close();
                stream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        try {
            //写入
            File newFile = new File("text2.txt");
            FileOutputStream outputStream = new FileOutputStream(newFile);
            OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            bufferedWriter.write("测试输入");

            bufferedWriter.close();
            writer.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


        //不带缓冲的流
        readWithoutBuffer();

        //带缓冲的流
        readWithBuffer();


        //使用Apache公共库
        apacheIO_Read();
    }

    public static void readWithoutBuffer() throws IOException {
        System.out.println("readWithoutBuffer");

        File file = new File("/Users/moqiaowen/Downloads/android-studio-ide-162.3871768-mac.dmg");

        System.out.println("file exists : " + file.exists());
        System.out.println("file size : " + file.length());

        FileInputStream stream = new FileInputStream(file);

        byte input[] = new byte[1024];

        int count = 0;

        long startTime = System.currentTimeMillis();
        while (stream.read(input) != -1) {
            count++;
        }

        System.out.println("read times : " + count);
        System.out.println("cost time : " + (System.currentTimeMillis() - startTime) + "ms");
        stream.close();
    }

    public static void readWithBuffer() throws IOException {
        System.out.println("readWithBuffer");

        File file = new File("/Users/moqiaowen/Downloads/android-studio-ide-162.3871768-mac.dmg");

        System.out.println("file exists : " + file.exists());
        System.out.println("file size : " + file.length());

        FileInputStream stream = new FileInputStream(file);
        BufferedInputStream bufferedStream = new BufferedInputStream(stream, 4096); //指定缓冲区大小

        byte input[] = new byte[1024];

        int count = 0;

        long startTime = System.currentTimeMillis();
        while (bufferedStream.read(input) != -1) {
            count++;
        }

        System.out.println("read times : " + count);
        System.out.println("cost time : " + (System.currentTimeMillis() - startTime) + "ms");
        stream.close();
        bufferedStream.close();
    }

    public static void apacheIO_Read() throws IOException {
        File file = new File("text.txt");
        String str = FileUtils.readFileToString(file);

        System.out.println("read file : \n" + str);
    }

}
