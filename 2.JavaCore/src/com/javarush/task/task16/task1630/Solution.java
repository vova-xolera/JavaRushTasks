package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.Scanner;


public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = scan.readLine();
            secondFileName = scan.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class ReadFileThread extends Thread implements ReadFileInterface  {
        private String st="";

        private String fullFileName;

        @Override
        public void setFileName(String fullFileName) {
            this.fullFileName=fullFileName;
        }

        @Override
        public String getFileContent() {
            return st;
        }

        @Override
        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
                String s;
                while ((s=reader.readLine())!=null)
                    st = st + s + " ";

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static synchronized void  systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        try {
            System.out.println(f.getFileContent());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent() throws FileNotFoundException;

        void join() throws InterruptedException;

        void start();
    }

}
