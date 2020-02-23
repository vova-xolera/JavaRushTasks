package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String name = scan.readLine();
        scan.close();
        BufferedReader filereader = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
        ArrayList Array = new ArrayList<>();
        while (filereader.ready()) {
            int number = Integer.parseInt(filereader.readLine());
            if (number % 2 == 0 && number != 0) {
                Array.add(number);
            }
        }
        filereader.close();
        Collections.sort(Array);
        for(int index = 0; index < Array.size(); index++){
            System.out.println(Array.get(index));
        }
    }
}
