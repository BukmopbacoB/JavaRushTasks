package com.javarush.task.task18.task1807;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int countSemicolon = 0;
        try {
            String fileName = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName);
            while (inputStream.available() > 0) {
                if (inputStream.read() == (int) ',') {
                    countSemicolon++;
                }
            }
            inputStream.close();
            reader.close();
            System.out.println(countSemicolon);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
