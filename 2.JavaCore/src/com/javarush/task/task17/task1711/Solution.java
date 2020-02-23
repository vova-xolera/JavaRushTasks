package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        if (args[i + 1].equals("м"))
                            allPeople.add(Person.createMale(args[i], df.parse(args[i + 2])));
                        else if (args[i + 1].equals("ж"))
                            allPeople.add(Person.createFemale(args[i], df.parse(args[i + 2])));
                        System.out.println(allPeople.size() - 1);
                    }
                    break;
                }

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i+=4) {
                        allPeople.get(Integer.parseInt(args[i])).setName(args[i + 1]);
                        if (args[i + 2].equals("м"))
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.MALE);
                        else if (args[i + 2].equals("ж"))
                            allPeople.get(Integer.parseInt(args[i])).setSex(Sex.FEMALE);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(df.parse(args[i + 3]));
                    }
                    break;
                }

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        allPeople.get(Integer.parseInt(args[i])).setName(null);
                        allPeople.get(Integer.parseInt(args[i])).setSex(null);
                        allPeople.get(Integer.parseInt(args[i])).setBirthDate(null);
                    }
                    break;
                }

            case "-i":
                synchronized (allPeople) {
                    SimpleDateFormat df1 = new SimpleDateFormat(" dd-MMM-yyyy", Locale.ENGLISH);
                    //System.out.println(args.length);
                    for (int i = 1; i < args.length; i++) {
                        Person current = allPeople.get(Integer.parseInt(args[i]));
                        System.out.println(current.getName() + " "
                                + (current.getSex().equals(Sex.MALE) ? "м" : current.getSex().equals(Sex.FEMALE) ? "ж" : null)
                                + df1.format(current.getBirthDate()));
                    }
                    break;
                }


        }
    }
}
