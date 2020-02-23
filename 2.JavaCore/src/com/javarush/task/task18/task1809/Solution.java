package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String file1 = scan.readLine();
        String file2 = scan.readLine();
        scan.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outStream = new FileOutputStream(file2);
        if (inputStream.available() > 0) {
            byte[] buffer = new byte[inputStream.available()];
            int count = inputStream.read(buffer);
            byte[] buffer2 = new byte[buffer.length];
            for (int i = 0; i < buffer.length; i++) {
                buffer2[i] = buffer[buffer.length - 1 - i];
            }
            outStream.write(buffer2, 0 , count);
        }
        inputStream.close();
        outStream.close();
    }
}
