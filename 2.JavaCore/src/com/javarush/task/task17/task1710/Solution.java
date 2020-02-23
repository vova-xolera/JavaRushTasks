package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat enterFormat = new SimpleDateFormat( "dd/MM/yyyy");
        SimpleDateFormat dateFormat = new SimpleDateFormat( "dd-MMM-yyyy", Locale.ENGLISH);
        if (args[0].equals("-c")) {
            Date date = enterFormat.parse(args[3]);
            Person person;
            if (args[2].equals("ж")) {
                person = Person.createFemale(args[1], (date));
                allPeople.add(person);
            }
            else {
                person = Person.createMale(args[1], (date));
                allPeople.add(person);
            }
            System.out.println(allPeople.size() - 1);
            System.out.println(allPeople.get(1).getName() + " " + allPeople.get(1).getSex() + " " + dateFormat.format(allPeople.get(1).getBirthDate()));

        }

        else if (args[0].equals("-u")) {
            Person person;
            if (args[3].equals("м")) {
                person = Person.createMale(args[2], enterFormat.parse(args[4]));
            }
            else {
                person = Person.createFemale(args[2], enterFormat.parse(args[4]));
            }
            allPeople.remove(Integer.parseInt(args[1]));
            allPeople.add(Integer.parseInt(args[1]), person);
            System.out.println(allPeople.size() - 1);
            System.out.println(person.getName() + " " + person.getSex() + " " + dateFormat.format(person.getBirthDate()));
        }

        else if (args[0].equals("-d")) {
            Person delPerson = allPeople.get(Integer.parseInt(args[1]));
            delPerson.setName(null);
            delPerson.setSex(null);
            delPerson.setBirthDate(null);
        }

        else if (args[0].equals("-i")) {
            Person findPerson = allPeople.get(Integer.parseInt(args[1]));
            String sex = "";
            if (findPerson.getSex().equals(Sex.FEMALE)) {
                sex = "ж";
            }
            else {
                sex = "м";
            }
            System.out.println(findPerson.getName() + " " + sex + " " + dateFormat.format(findPerson.getBirthDate()));
        }
    }
}
