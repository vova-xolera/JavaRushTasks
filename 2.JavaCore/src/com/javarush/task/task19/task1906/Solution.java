package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        scan.close();
        FileReader reader = new FileReader(fileName1);
        FileWriter writer = new FileWriter(fileName2);
        while (reader.ready()) {
            int one = reader.read();
            if (reader.ready()) {
                int two = reader.read();
                writer.write(two);
            }
        }
        reader.close();
        writer.close();
    }
}
