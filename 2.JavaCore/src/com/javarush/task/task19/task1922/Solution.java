package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {

    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static boolean wordExam(String sWord, String str) {
        String[] strArray = str.split(" ");
        for (String temp: strArray) {
           if(temp.equals(sWord)) {
               return true;
           }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String name = nameReader.readLine();
        nameReader.close();
        BufferedReader scan = new BufferedReader(new FileReader(name));
        while (scan.ready()) {
            int score = 0;
            String str = scan.readLine();
            for (String word: words) {
                if (wordExam(word, str)) score++;
            }
            if (score == 2) {
                System.out.println(str);
            }
        }
        scan.close();
    }
}
