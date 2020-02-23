package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = null;
        try {
            file1 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String file2 = null;
        try {
            file2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file1)))) {
            while (readerFile.ready()) {
                allLines.add(readerFile.readLine());

            }
        } catch (IOException e) {
        }


        try (BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(file2)))) {
            while (readerFile.ready()) {
                forRemoveLines.add(readerFile.readLine());
            }
        } catch (IOException e) {
        }

        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}