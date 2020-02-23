package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String fileName = scan.readLine();;
        while (!fileName.equals("exit")) {
           ReadThread readThread = new ReadThread(fileName);
           readThread.start();
           fileName = scan.readLine();
        }
        resultMap.entrySet().forEach(entry->{
            System.out.println(entry.getKey() + " " + entry.getValue());
        });
    }

    public static class ReadThread extends Thread {
        public ReadThread(String fileName) throws IOException {
            FileInputStream inputStream = new FileInputStream(fileName);
            fileReader(fileName, inputStream);
        }

        private void fileReader(String fileNAme, FileInputStream inputStream) throws IOException {
            byte[] list = new byte[inputStream.available()];
            int count = inputStream.read(list);
            int count1 = count;
            int max = 0;
            int Byte = 0;
            int localMax = 0;
            for (int i = 0; i < 256; i++) {
                while (count1 - 1 >= 0) {
                    if (i == list[count1 - 1]) localMax++;
                    count1--;
                }
                if (max < localMax) {
                    max = localMax;
                    Byte = i;
                }
                count1 = count;
                localMax = 0;
                }
               resultMap.put(fileNAme,Byte);
               inputStream.close();
            }
        }
    }

