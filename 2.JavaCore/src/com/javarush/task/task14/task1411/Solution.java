package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Loser, Coder and Proger
*/

public class Solution implements Person {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;
        Boolean result = true;
        while (result)
        {
            key = reader.readLine();

            if(key.equals("user")) {
                User user = new User();
                doWork(user);
            }
            else if(key.equals("loser")) {
                Loser loser = new Loser();
                doWork(loser);
            }
            else if(key.equals("coder")) {
                Coder coder = new Coder();
                doWork(coder);
            }
            else if(key.equals("proger")) {
                Proger proger = new Proger();
                doWork(proger);
            }
            else result = false;
        }
    }

    public static void doWork(Person person) {
        if (person instanceof User) {
            ((User) person).live();
        }
        else if (person instanceof Loser) {
            ((Loser) person).doNothing();
        }
        else if (person instanceof Coder) {
            ((Coder) person).writeCode();
        }
        else if (person instanceof Proger) {
            ((Proger) person).enjoy();
        }
    }
}
