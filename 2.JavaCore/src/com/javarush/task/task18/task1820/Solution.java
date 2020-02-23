package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        scan.close();

        FileInputStream fileInputStream = new FileInputStream(fileName1);
        FileOutputStream outStream = new FileOutputStream(fileName2);
        byte[] line = new byte[fileInputStream.available()];
        int count = fileInputStream.read(line);
        ArrayList<String> list = new ArrayList<>(Arrays.asList(new String(line).split(" ")));
        StringBuilder result = new StringBuilder();
        for (String s : list) result.append((int) Math.round(Double.parseDouble(s))).append(" ");
        byte[] wData = result.toString().getBytes();

        outStream.write(wData);
        fileInputStream.close();
        outStream.close();
    }
}
