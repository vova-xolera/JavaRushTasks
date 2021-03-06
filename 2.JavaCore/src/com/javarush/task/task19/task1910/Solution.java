package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        scan.close();
        BufferedReader reader = new BufferedReader(new FileReader(fileName1));
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
        while (reader.ready())
        writer.write(reader.readLine().replaceAll("[^\\w\\d\\s]", ""));
        reader.close();
        writer.close();
    }
}
