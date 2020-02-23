package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream outStream = new PrintStream(stream);
        System.setOut(outStream);
        testString.printSomething();
        StringBuilder sb = new StringBuilder(stream.toString());
        System.setOut(console);
        String[] strings = sb.toString().split(" ");
        int result = 0;
        if (sb.indexOf("-") != -1) {
            result = Integer.parseInt(strings[0]) - Integer.parseInt(strings[2]);
        }
        else if (sb.indexOf("+") != -1) {
            result = Integer.parseInt(strings[0]) + Integer.parseInt(strings[2]);
        }
        else if (sb.indexOf("*") != -1) {
            result = Integer.parseInt(strings[0]) * Integer.parseInt(strings[2]);
        }
        else {
            result = Integer.parseInt(strings[0]) / Integer.parseInt(strings[2]);
        }

        System.out.println(sb.substring(0,sb.length() - 1) + (result));
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

