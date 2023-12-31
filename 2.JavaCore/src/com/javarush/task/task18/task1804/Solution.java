package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        
        int[] repeat = new int[256];
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                repeat[inputStream.read()] += 1;
            }
        }
        int min = Integer.MAX_VALUE;
        for (int b : repeat) {
            if (b > 0 && b < min) min = b;
        }

        for (int i = 0; i < repeat.length; i++) {
            if (repeat[i] == min) {
                System.out.print(i + " ");
            }
        }
    }
}
