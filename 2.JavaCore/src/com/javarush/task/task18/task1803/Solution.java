package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        int max = 0;
        int[] rep = new int[256];
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            while (inputStream.available() > 0) {
                int in = inputStream.read();
                rep[in] += 1;
                if (rep[in] > max) max = rep[in];
            }
        }
//        System.out.println(max);
        for (int i = 0; i < 256; i++) {
            if (rep[i] == max) {
                System.out.print(/*(char)*/ i + " ");
            }
        }
        reader.close();
    }
}
