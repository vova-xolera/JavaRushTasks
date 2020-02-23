package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String fileName = args[0];
        BufferedReader scan = new BufferedReader(new FileReader(fileName));
        while (scan.ready()) {
            String string = scan.readLine();
            String[] strings = string.split(" ");
            StringBuilder sb = new StringBuilder(strings[0]);
            for (int i = 1; i < strings.length - 3; i++) {
                sb.append(" ");
                sb.append(strings[i]);
            }

            DateFormat format = new SimpleDateFormat("d M y");
            Date date = format.parse(strings[strings.length - 3] + " " + strings[strings.length - 2] + " " + strings[strings.length - 1]);
            PEOPLE.add(new Person(sb.toString(),date));
        }
        scan.close();
    }
}
