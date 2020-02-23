package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {
    int intVar = 0;
    double doubleVar = 0;
    Double DoubleVar = 0.0;
    boolean booleanVar = true;
    Object ObjectVar = null;
    Exception ExceptionVar = null;
     String StringVar = null;
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.intVar);
        System.out.println(sol.doubleVar);
        System.out.println(sol.DoubleVar);
        System.out.println(sol.booleanVar);
        System.out.println(sol.ObjectVar);
        System.out.println(sol.ExceptionVar);
        System.out.println(sol.StringVar);
    }

}
