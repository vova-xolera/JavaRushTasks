package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String word;
        while (true) {
            word = scan.readLine();
            if (word.equals("exit")) {
                break;
            }
            Boolean flag = false;
            char[] Cword = word.toCharArray();
            for (int index = 0; index < Cword.length; index++) {
                if (Cword[index] == '.') {
                    Double Dword = Double.parseDouble(word);
                    print(Dword);
                    flag = true;
                    break;
                }
                else if (!(Cword[index] >= '0' && Cword[index] <= '9')) {
                    print(word);
                    flag = true;
                    break;
                }
            }
            if (flag) {break;}
            int Iword = Integer.parseInt(word);
            if (Iword >= 0 && Iword < 128) {
                short ShortWord = (short) Iword;
                print(ShortWord);
            }
            else {
                print(Iword);
            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
