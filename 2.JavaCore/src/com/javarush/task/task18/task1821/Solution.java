package com.javarush.task.task18.task1821;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/* 
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        int[] table = new int[256];

        try {
            int letter = bufferedReader.read();
            while (letter != -1) {
                table[(byte)letter] += 1;
                letter = bufferedReader.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        bufferedReader.close();
        for (int i = 0; i < table.length; i++) {
            if (table[i] != 0) {
                System.out.println((char) (i) + " " + table[i]);
            }
        }
    }
}
