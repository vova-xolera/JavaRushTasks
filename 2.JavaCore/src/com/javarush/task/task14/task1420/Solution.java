package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            int a = Integer.parseInt(scan.readLine());
            if (a < 1) {
                throw new IOException();
            }
            int b = Integer.parseInt(scan.readLine());
            if (b < 1) {
                throw new IOException();
            }

        int result = 1;
            for (int index = a / 2; index >= 1; index--) {
                if (a % index == 0) {
                    if (b % index == 0) {
                        result = index;
                        break;
                    }
                }
            }
        System.out.println(result);
    }
}
