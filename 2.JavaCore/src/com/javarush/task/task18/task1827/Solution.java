package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        //#1
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));


        String id = null;
        String productName = null;
        String price = null;
        String quantity = null;


        //#2
        if (args.length == 4) {
            id = padRight(String.valueOf(getMaxId(fileName) + 1), 8);
            productName = padRight(args[1], 30);
            price = padRight(args[2], 8);
            quantity = padRight(args[3], 4);
            out.newLine();
            out.write(id + productName + price + quantity);
            out.close();
        }
    }

    private static String padRight(String input, int length) {
        if (input.length() < length) {
            return String.format("%1$-" + length + "s", input);
        } else {
            return input.substring(0, length);
        }
    }

    private static long getMaxId(String fileName) throws IOException {
        BufferedReader fileReader = new BufferedReader(new FileReader(fileName));
        long maxId = 0;
        long currId;
        String line;
        while ((line = fileReader.readLine()) != null) {
            currId = Integer.parseInt(line.substring(0, 8).trim());
            if (currId > maxId) {
                maxId = currId;
            }
        }
        fileReader.close();
        return maxId;
    }
}
