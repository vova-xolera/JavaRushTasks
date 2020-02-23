package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        Map<String,byte[]> resultMap = new TreeMap<>();
        String fileName = "";

        fileName = scan.readLine();
        int index = fileName.lastIndexOf(".");
        StringBuilder firstsb = new StringBuilder(fileName);
        String newFileName = firstsb.substring(0,index);
        String partFileName = firstsb.substring(index + 1);
        FileInputStream firstInStream = new FileInputStream(fileName);
        byte[] list = new byte[firstInStream.available()];
        firstInStream.read(list);
        resultMap.put(partFileName, list);
        firstInStream.close();

        while (true) {
            fileName = scan.readLine();
            if (fileName.equals("end")) break;
            index = fileName.lastIndexOf(".");
            StringBuilder sb = new StringBuilder(fileName);
            partFileName = sb.substring(index + 1);
            FileInputStream inStream = new FileInputStream(fileName);
            list = new byte[inStream.available()];
            inStream.read(list);
            resultMap.put(partFileName, list);
            inStream.close();
        }
        scan.close();

        FileOutputStream outStream = new FileOutputStream(newFileName);
        resultMap.entrySet().forEach(entry->{
            try {
                outStream.write(entry.getValue());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        outStream.close();
    }
}
