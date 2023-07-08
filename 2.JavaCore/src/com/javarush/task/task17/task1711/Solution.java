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

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
        Date date;
        switch (args[0]) {
            case "-c" :
                // TODO проверка на наличие всех параметров
                try {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i += 3) {
                            date = formatIn.parse(args[i + 2]);
                            person = args[i + 1].equals("м") ? Person.createMale(args[i], date) : Person.createFemale(args[i], date);
                            allPeople.add(person);
                            System.out.println(allPeople.indexOf(person));
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "-i" :
                // TODO проверка на наличие всех параметров
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                        System.out.println(person.getName() + " " + sex + " " + formatter.format(person.getBirthDate()));
                    }
                }
                break;
            case "-u" :
                // TODO проверка на наличие всех параметров
                try {
                    synchronized (allPeople) {
                        for (int i = 1; i < args.length; i +=4) {
                            date = formatIn.parse(args[i + 3]);
                            person = allPeople.get(Integer.parseInt(args[i]));
                            person.setName(args[i + 1]);
                            person.setSex((args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE));
                            person.setBirthDate(date);
                            allPeople.set(Integer.parseInt(args[i]), person);
                        }
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "-d" :
                // TODO проверка на наличие всех параметров
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                        allPeople.set(Integer.parseInt(args[i]), person);
                    }
                }
                break;
        }
    }
}
