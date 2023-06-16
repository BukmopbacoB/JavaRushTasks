package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Клубок
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        Thread thread3 = new Thread3();
        Thread thread4 = new Thread4();
        Thread thread5 = new Thread5();
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(thread4);
        threads.add(thread5);

        for (Thread t : threads) {
            t.start();
        }

    }

    public static void main(String[] args) {
    }

    public static class Thread1 extends Thread {
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            Thread current = Thread.currentThread();
            while (!current.isInterrupted()) {
                try {
                } catch (Exception e) {
                    e.printStackTrace();
                    current.interrupt();
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            try {
                while (true) {
                    sleep(500);
                    System.out.println("Ура");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        Thread current = Thread.currentThread();
        @Override
        public void run() {
            while (!current.isInterrupted()) {

            }
        }

        @Override
        public void showWarning() {
            if (current.isAlive()) {
                current.interrupt();
            }
        }
    }

    public static class Thread5 extends Thread {
        int sum = 0;
        @Override
        public void run() {
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            while (!s.equals("N")) {
                sum += Integer.parseInt(s);
                s = scanner.nextLine();
            }
            System.out.println(sum);
        }
    }

}