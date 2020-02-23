package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;


import static java.util.Map.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream(args[0]);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < 128; i++) {
            map.put(i, 0);
        }
        while (inputStream.available() > 0) {
            int value = inputStream.read();
            for (int i = 0; i < map.size(); i++) {
                if (value == i) {
                    map.replace(i, map.get(i) + 1);
                    break;
                }
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            char k = (char) entry.getKey().byteValue();
            int v = entry.getValue();
            if (v != 0) {
                System.out.println(k + " " + v);
            }
        }
        inputStream.close();
    }
}
