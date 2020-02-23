package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(2.5,"ring");
        labels.put(3.5,"ring1");
        labels.put(2.51,"ring2");
        labels.put(2.25,"ring3");
        labels.put(2.59,"ring4");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }


}
