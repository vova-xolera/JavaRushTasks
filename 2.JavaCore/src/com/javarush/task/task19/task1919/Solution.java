package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        TreeMap<String, Double> map = new TreeMap<>();
        while (reader.ready()) {
            String line = reader.readLine();
            String[] array = line.split(" ");
            if (map.containsKey(array[0])) {
                map.replace(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
            }
            else map.put(array[0], Double.parseDouble(array[1]));
        }
        reader.close();
        for(Map.Entry e : map.entrySet()){
            System.out.println(e.getKey()+" "+ e.getValue());
        }
    }
}
