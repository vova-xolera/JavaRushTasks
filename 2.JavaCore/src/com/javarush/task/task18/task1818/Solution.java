package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        String fileName3 = scan.readLine();
        scan.close();
        FileOutputStream outputStream = new FileOutputStream(fileName1);
        FileInputStream inputStream2  = new FileInputStream(fileName2);
        FileInputStream inputStream3 = new FileInputStream(fileName3);
        while (inputStream2.available() > 0) {
            int num = inputStream2.read();
            outputStream.write(num);
        }
        while (inputStream3.available() > 0) {
            int num = inputStream3.read();
            outputStream.write(num);
        }
        outputStream.close();
        inputStream2.close();
        inputStream3.close();
    }
}
