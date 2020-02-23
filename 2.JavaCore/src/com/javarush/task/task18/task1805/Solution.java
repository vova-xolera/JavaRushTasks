package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import static java.util.Collections.frequency;

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList list = new ArrayList ();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream inputStream =new FileInputStream(file);
        int count = 0;
        while (inputStream.available()>0) {
            count = inputStream.read();
            if (!list.contains(count)) {
                list.add(count);
            }
        }
        Collections.sort(list);
        for(int i=0;list.size()>i;i++){
            System.out.print(list.get(i) + " ");
            }
        inputStream.close();
    }
}