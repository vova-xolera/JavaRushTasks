package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = scan.readLine();
        String fileName2 = scan.readLine();
        String fileName3 = scan.readLine();
        scan.close();
        FileInputStream inputReader = new FileInputStream(fileName1);
        FileOutputStream outputStream2 = new FileOutputStream(fileName2);
        FileOutputStream outputStream3 = new FileOutputStream(fileName3);


        if (inputReader.available() > 0) {
            byte[] buffer = new byte[inputReader.available()];
            int count = inputReader.read(buffer);

                outputStream2.write(buffer, 0, count - count/2);
                outputStream3.write(buffer, count - count/2,  count/2);

        }
        inputReader.close();
        outputStream2.close();
        outputStream3.close();
    }
}
