package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader( new InputStreamReader(System.in));
        String fileName = scan.readLine();
        scan.close();
        PrintStream console = System.out;
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outStream);
        System.setOut(printStream);
        testString.printSomething();
        String result = outStream.toString();
        FileOutputStream fileWriter = new FileOutputStream(fileName);
        fileWriter.write(result.getBytes());
        fileWriter.close();
        System.setOut(console);
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

