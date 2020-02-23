package com.javarush.task.task16.task1622;

/* 
Последовательные выполнения нитей
*/

public class Solution {
    public volatile static int COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < COUNT; i++) {
            new SleepingThread().join();
        }
    }

    public static class SleepingThread extends Thread {
        private static volatile int threadCount = 0;
        private volatile int countdownIndex = COUNT;

        public SleepingThread() {
            super(String.valueOf(++threadCount));
            start();
        }

        public void run() {
            while (true) {
                try {
                System.out.println(this);
                    Thread.sleep(10);
                if (--countdownIndex == 0) {
                    break;
                }
                } catch (InterruptedException e) {
                    System.out.println("Нить прервана");
                }
            }
        }
        public String toString() {
            return "#" + getName() + ": " + countdownIndex;
        }
    }
}
