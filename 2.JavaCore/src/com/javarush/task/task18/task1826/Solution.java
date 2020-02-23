package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        FileInputStream inStream = new FileInputStream(fileName);
        String newFileName = args[2];
        FileOutputStream outStream = new FileOutputStream(newFileName);

        if (args[0].equals("-e")) {
            while (inStream.available() > 0) {
                outStream.write(inStream.read() - 1);
            }
        }
        else if (args[0].equals("-d")) {
            while (inStream.available() > 0){
                outStream.write( inStream.read() + 1);
            }
        }
        inStream.close();
        outStream.close();
    }

}
