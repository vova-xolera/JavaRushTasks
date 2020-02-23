package com.javarush.task.task16.task1619;

/* 
А без interrupt слабо?
*/

import jdk.nashorn.internal.runtime.regexp.joni.exception.InternalException;

public class Solution {
    public static boolean isCansel = true;
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new TestThread());
        t.start();
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        Solution.isCansel = false;
    }

    public static class TestThread implements Runnable {
        public void run() {
            while (isCansel) {
                try {
                    System.out.println("he-he");
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }
}
