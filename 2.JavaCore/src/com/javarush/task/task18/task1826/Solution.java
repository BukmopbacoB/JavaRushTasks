package com.javarush.task.task18.task1826;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Шифровка
*/

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        byte[][] arr = new byte[5][10];
        try (FileInputStream fileInputStream = new FileInputStream(args[1]);
             FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {
            int initKey = 0;
            int key = 0;
            if (args[0].equals("-e")) {
                key = 2;
            } else if (args[0].equals("-d")) {
                key = -2;
            } else {
                return;
            }
            while (fileInputStream.available() > 0) {
                fileOutputStream.write(fileInputStream.read() + initKey + key);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
