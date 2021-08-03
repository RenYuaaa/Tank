package com.study.tank.dadpter;

import java.io.*;

/**
 * @author: renjiahui
 * @date: 2021-08-04 0:00
 * @description: 适配器模式--适用于A要通过B访问C的一种模式
 */
public class Main {

    public static void main(String[] args) throws IOException {

        // 读取一个本地文件
        FileInputStream fileInputStream = new FileInputStream("c:/test.text");

        // 为了读取文件的文字，将输入流转换为Reader
        InputStreamReader streamReader = new InputStreamReader(fileInputStream);

        // 读取文字
        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String readLine = bufferedReader.readLine();

        while (readLine != null && !readLine.equals("")) {
            System.out.println(readLine);
        }

        bufferedReader.close();
        streamReader.close();
        fileInputStream.close();
    }
}
