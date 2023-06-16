package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = reader.readLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(readLine));
        readLine = reader.readLine();
        while (!readLine.equals("exit")) {
            writer.write(readLine);
            writer.write("\n");
            readLine = reader.readLine();
        }
        writer.write(readLine);
        writer.flush();
        writer.close();
    }
}
