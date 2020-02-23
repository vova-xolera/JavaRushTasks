package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        scan.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        StringBuilder sb = new StringBuilder();
        sb.append(reader.readLine());
        reader.close();
        String[] strings = sb.toString().split(" ");
        for ( String s : strings) {
            try {
                writer.write(Integer.parseInt(s) + " ");
            }
            catch (NumberFormatException ex) {
            }
        }
        writer.close();
    }
}
