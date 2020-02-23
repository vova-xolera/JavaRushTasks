package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        String name = read.readLine();
        File file = new File(name);
        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter write = new BufferedWriter(fileWriter);
        String line;
        while(!(line = read.readLine()).equals("exit")) {
            write.write(line);
            write.newLine();
        }
        write.write("exit");
        read.close();
        write.close();
    }
}
