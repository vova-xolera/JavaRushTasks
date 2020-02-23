package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader streamIn = new BufferedReader(new InputStreamReader(System.in));
        String fileName = streamIn.readLine();
        streamIn.close();
        FileInputStream fileStream = new FileInputStream(fileName);
        byte max = 0;
        while (fileStream.available() > 0) {
            byte data = (byte) fileStream.read();
            if (max < data) max = data;
        }
        fileStream.close();
        System.out.println(max);
    }
}
