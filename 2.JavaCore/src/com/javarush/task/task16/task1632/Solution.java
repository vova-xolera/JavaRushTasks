package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class firstThread extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }
    public static class secondThread extends Thread {
        @Override
        public void run() {
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.out.println("InterruptedException");
        }
        }
    }
    public static class thirdThread extends Thread {
        @Override
        public void run() {
            while(true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static class forthThread extends Thread implements Message {
        @Override
        public void run() {
            while(!isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }
    public static class fiveThread extends Thread  {
        @Override
        public void run() {
            BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
            int summ = 0;
            while(!isInterrupted()) {
            String s = "";;
            try {
                s = scan.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
                if (s.equals("N")) {
                    System.out.println(summ);
                    this.interrupt();
                }
                else {
                    int n = 0;
                    n = Integer.parseInt(s);
                    summ = summ + n;
                }
            }
        }

    }
    public static List<Thread> threads = new ArrayList<>(5);

    static {

        threads.add(new firstThread());
        threads.add(new secondThread());
        threads.add(new thirdThread());
        threads.add(new forthThread());
        threads.add(new fiveThread());

    }

    public static void main(String[] args) {
        for (Thread a:threads){
            a.start();
        }
    }
}