package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter number 1: ");
//        int num1 = scanner.nextInt();
//        System.out.print("Enter number 2: ");
//        int num2 = scanner.nextInt();
//
//        System.out.println("GCD: " + gcdByEuclidsAlgorithm(num1, num2));
//    }
//
//    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
//        if (n2 == 0) {
//            return n1;
//        }
//        return gcdByEuclidsAlgorithm(n2, n1 % n2);
//    }
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int first = Integer.parseInt(reader.readLine());
        int second = Integer.parseInt(reader.readLine());

        System.out.println(getNOD(first, second));
    }

    private static int getNOD(int first, int second) {
        if (first < 1 || second < 1) {
            throw new IllegalArgumentException();
        }

        while (first != second) {
            if (first > second) {
                first -= second;
            }
            if (second > first) {
                second -= first;
            }
        }
        return first;
    }
}
