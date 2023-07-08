package com.javarush.task.task17.task1710;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-YYYY", Locale.ENGLISH);
        SimpleDateFormat formatIn = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person;
        switch (args[0]) {
            case "-c" :
                // TODO проверка на наличие всех параметров
                try {
                    Date date = formatIn.parse(args[3]);
                    person = args[2].equals("м") ? Person.createMale(args[1], date) : Person.createFemale(args[1], date);
                    allPeople.add(person);
                    System.out.println(allPeople.indexOf(person));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "-r" :
                // TODO проверка на наличие всех параметров
                person = allPeople.get(Integer.parseInt(args[1]));
                String sex = person.getSex().equals(Sex.MALE) ? "м" : "ж";
                System.out.println(person.getName() + " " + sex + " " + formatter.format(person.getBirthDate()));
                break;
            case "-u" :
                // TODO проверка на наличие всех параметров
                try {
                    Date date = formatIn.parse(args[4]);
                    person = allPeople.get(Integer.parseInt(args[1]));
                    person.setName(args[2]);
                    person.setSex((args[3].equals("м") ? Sex.MALE : Sex.FEMALE));
                    person.setBirthDate(date);
                    allPeople.set(Integer.parseInt(args[1]), person);
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

                break;
            case "-d" :
                // TODO проверка на наличие всех параметров
                person = allPeople.get(Integer.parseInt(args[1]));
                person.setName(null);
                person.setSex(null);
                person.setBirthDate(null);
                allPeople.set(Integer.parseInt(args[1]), person);
                break;
        }
    }
}
