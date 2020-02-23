package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import javafx.print.Collation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        String fileName = args[0];
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        TreeMap<String, Double> map = new TreeMap<>();
        String line = reader.readLine();
        String[] array = line.split(" ");
        map.put(array[0], Double.parseDouble(array[1]));
        double max = Double.parseDouble(array[1]);
        while (reader.ready()) {
            line = reader.readLine();
            array = line.split(" ");
            if (map.containsKey(array[0])) {
                map.replace(array[0], map.get(array[0]) + Double.parseDouble(array[1]));
            }
            else map.put(array[0], Double.parseDouble(array[1]));
        }
        reader.close();
        for(Map.Entry e : map.entrySet()){
           if (max < (double) e.getValue()) max = (double) e.getValue();
        }
        for(Map.Entry e : map.entrySet()){
            if (max == (double) e.getValue()) System.out.println(e.getKey());
        }
    }
}
