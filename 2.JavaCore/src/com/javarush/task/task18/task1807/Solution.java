package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName = scan.readLine();
        scan.close();
        FileInputStream inputStream = new FileInputStream(fileName);
        int count = 0;
        while (inputStream.available() > 0) {
            if (inputStream.read() == 44) {
                count++;
            }
        }
        System.out.print(count);
        inputStream.close();
    }
}
