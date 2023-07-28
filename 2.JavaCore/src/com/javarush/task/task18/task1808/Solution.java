package com.javarush.task.task18.task1808;

import java.io.*;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            String fileName3 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream = new FileOutputStream(fileName2);

            int countByte = (inputStream.available() % 2 == 0) ? inputStream.available() / 2 : inputStream.available() / 2 + 1;
            byte[] buffer = new byte[countByte];
            int count = inputStream.read(buffer, 0, countByte);
            outputStream.write(buffer, 0, count);
            outputStream.close();
            outputStream = new FileOutputStream(fileName3);
            count = inputStream.read(buffer, 0, inputStream.available());
            outputStream.write(buffer, 0, count);

            inputStream.close();
            outputStream.close();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
