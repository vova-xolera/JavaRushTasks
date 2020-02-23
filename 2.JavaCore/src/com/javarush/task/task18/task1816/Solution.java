package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        int summ = 0;
        FileInputStream inStream = new FileInputStream(fileName);
        while(inStream.available() > 0) {
            int a = inStream.read();
            if ((a >= 0x41 && a <= 0x5A) || (a >= 0x61 && a <= 0x7A)) summ++;
        }
        System.out.print(summ);
        inStream.close();
    }
}
