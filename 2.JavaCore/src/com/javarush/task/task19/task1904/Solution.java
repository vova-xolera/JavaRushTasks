package com.javarush.task.task19.task1904;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
       private Scanner fileScanner;

        PersonScannerAdapter (Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException, ParseException {
                String[] list = fileScanner.nextLine().split(" ", 4);
                SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
                Date date = formatter.parse(list[3]);
                return new Person(list[1], list[2], list[0], date);

        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
