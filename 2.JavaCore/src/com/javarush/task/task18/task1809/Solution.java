package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String fileName1 = reader.readLine();
            String fileName2 = reader.readLine();
            FileInputStream inputStream = new FileInputStream(fileName1);
            FileOutputStream outputStream = new FileOutputStream(fileName2);

            int count = inputStream.available();
            byte[] buffer = new byte[count];
            count = inputStream.read(buffer, 0, count);
            for (int i = 0; i < count / 2; i++) {
                int tmp = buffer[i];
                buffer[i] = buffer[count - 1 - i];
                buffer[count - 1 - i] = (byte) tmp;
            }
            outputStream.write(buffer);

            inputStream.close();
            outputStream.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
