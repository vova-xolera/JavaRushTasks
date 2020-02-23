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

    public static boolean wordExam(String sWord, char[] str) {
        char[] word = sWord.toCharArray();
        boolean bWord = false;
        for (int i = 0; i < str.length; i++) {
            if (str[i] == word[0]) {
                int numb = 0;
                for (int j = 0; j < word.length; j++) {
                    if (i + numb < str.length) {
                        if (str[i + numb] != word[j])
                            bWord = false;
                        break;
                    }
                    numb++;
                    bWord = true;
                }
                if(bWord) break;
            }
        }
        return bWord;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader nameReader = new BufferedReader(new InputStreamReader(System.in));
        String name = nameReader.readLine();
        BufferedReader scan = new BufferedReader(new FileReader(name));
        while (scan.ready()) {
            int score = 0;
            String str = scan.readLine();
            char array[] = str.toCharArray();
            if (wordExam(words.get(0), array)) score++;
            if (wordExam(words.get(1), array)) score++;
            if (wordExam(words.get(2), array)) score++;
            if (score == 2) { for (char c : array) System.out.println(c);
            }
        }
        nameReader.close();
        scan.close();
    }
}
