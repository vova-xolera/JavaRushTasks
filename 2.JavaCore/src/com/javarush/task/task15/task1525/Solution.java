package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static com.javarush.task.task15.task1525.Statics.FILE_NAME;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try{
            FileInputStream fstream = new FileInputStream(FILE_NAME);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String line;
            while ((line = br.readLine()) != null){

                lines.add(line);
            }
        }catch (IOException e){
            System.out.println("Ошибка");
        }
        for (String c: lines) {
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
    }
}

