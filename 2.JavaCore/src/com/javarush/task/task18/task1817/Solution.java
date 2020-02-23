package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        double sp = 0;
        FileInputStream inStream = new FileInputStream(fileName);
        double oth = inStream.available();
        while(inStream.available() > 0) {
            int num = inStream.read();
            if (num == 32) sp++;
        }
        Locale locale = new Locale("en");
        Locale.setDefault(locale);
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format( sp / oth *100);
        System.out.println(format);
        inStream.close();
    }
}
