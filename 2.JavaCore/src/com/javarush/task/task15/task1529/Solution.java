package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution  {
    public static void main(String[] args) {

    }
    
    static {
        try {
            reset();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static CanFly result;

    public static void reset() throws IOException {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        String par = null;
        try {
            par = scan.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (par.equals("helicopter")) {
            result = new Helicopter();
        }
        else if (par.equals("plane")) {
            int parInt = 0;
            try {
                parInt = Integer.parseInt(scan.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            result = new Plane(parInt);
        }
        else {
            result = null;
        }
        scan.close();
    }
}