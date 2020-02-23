package com.javarush.task.task15.task1522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Закрепляем паттерн Singleton
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static Planet thePlanet;

    static  {
        readKeyFromConsoleAndInitPlanet();
    }

    public static void readKeyFromConsoleAndInitPlanet() {
        BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
        try {
            String word = scan.readLine();
            if (word.equals(thePlanet.SUN)) {
                thePlanet = Sun.getInstance();
            }
            else if (word.equals(thePlanet.EARTH)) {
                thePlanet = Earth.getInstance();
            }
            else if (word.equals(thePlanet.MOON)) {
                thePlanet = Moon.getInstance();
            }
            else {
                throw new IOException();
            }

        }
        catch (IOException e) {
            thePlanet = null;
        }
    }
}