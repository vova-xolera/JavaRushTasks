package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        Pattern pattern = Pattern.compile("\\W");
        int count = 0;
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName = scan.readLine();
        scan.close();
        FileReader reader = new FileReader(fileName);
        StringBuilder sb = new StringBuilder();
        while(reader.ready()) {
            sb.append((char)reader.read());
        }
        reader.close();
        String[] strings = pattern.split(sb);
        for (String s : strings) {
            if (s.equals("world")) count++;
        }
        System.out.println(count);
    }
}
