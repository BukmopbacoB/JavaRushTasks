package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
//        String dirName = "C:\\Users\\bukmo\\Study\\JavaRush\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\task18\\task1801\\";

        int max = 0;
        try (FileInputStream inputStream = new FileInputStream(/*dirName + */fileName)) {
            while (inputStream.available() > 0) {
                int in = inputStream.read();
                if (in > max) max = in;
            }
        }
        System.out.println(max);
    }
}
