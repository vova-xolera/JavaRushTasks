package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            String fileName = scan.readLine();
            try {
                ReadThread readThread = new ReadThread(fileName);
                readThread.start();
            } catch (FileNotFoundException e) {
                System.out.println(fileName);
                Thread.interrupted();
                break;
            }
        }
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws IOException {
            FileInputStream inputStream = new FileInputStream(fileName);
            inputStream.close();
        }
    }
}
