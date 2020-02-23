package com.javarush.task.task15.task1527;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        try {
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            String s = scan.readLine();
            char[] URL = s.toCharArray();
            for (int index = 0; index < URL.length; index++) {
                if (URL[index] == '?' || URL[index] == '&') {
                    ArrayList<Character> charList = new ArrayList<>();
                    char[] obj = {'o', 'b', 'j'};
                    while (!(URL[index] == '=')) {
                        charList.add(URL[index]);
                        index++;
                    }
                    charprint(charList);
                    System.out.print(" ");
                    if (charList.size() == 4 && obj[0] == charList.get(1) && obj[1] == charList.get(2) && obj[2] == charList.get(3)) {
                        index++;
                        String word = "";
                        while ( index < URL.length && URL[index] != '&') {
                            word = word + URL[index];
                            index++;
                        }
                        index--;
                        list.add(word);
                    }
                }
            }
        }
        catch (IOException e) {
        }
        for (int index = 0; index < list.size(); index++) {
            try {
                double number = Double.parseDouble(list.get(index));
                System.out.println("");
                alert(number);
            }
            catch (Exception ex) {
                System.out.println("");
                alert(list.get(index));
            }
        }
    }
    public static void charprint(ArrayList<Character> list) {
        for (int index = 1; index < list.size(); index++) {
            if (list.get(index) == '&') {
                list.set(index, ' ');
            }
            System.out.print(String.valueOf(list.get(index)));
        }
    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }
    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}