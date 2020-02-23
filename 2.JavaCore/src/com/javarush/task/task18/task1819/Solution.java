package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        FileInputStream inStream = new FileInputStream(fileName1);
        byte[] list = new byte[inStream.available()];
        int count = inStream.read(list);
        FileInputStream inStream2 = new FileInputStream(fileName2);
        byte[] list2 = new byte[inStream2.available()];
        int count2 = inStream2.read(list2);
        byte[] list3 = new byte[count + count2];
        System.arraycopy(list2,0,list3,0,count2);
        System.arraycopy(list,0,list3,count2,count);
        FileOutputStream outStream = new FileOutputStream(fileName1);
        outStream.write(list3);
        inStream.close();
        inStream2.close();
        outStream.close();
    }
}
