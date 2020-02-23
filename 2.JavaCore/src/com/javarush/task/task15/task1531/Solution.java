package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger result = new BigInteger("1");
        String[] list = new String[16];
        if (n < 0) {
            result = new BigInteger("0");
        }
        else if (n == 0) {
        }
        else {
            for (int index = 1; index <= n; index++) {
                result = new BigInteger(result.multiply(BigInteger.valueOf(index)) + "");
            }
        }
        return result + "";
    }
}
