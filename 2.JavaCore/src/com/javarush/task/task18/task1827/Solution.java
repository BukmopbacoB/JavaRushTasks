package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].startsWith("-")) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        switch (args[0]) {
            case "-c" :
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String newId;
                String currentId;
                int maxId = 0;
                int idLength = 8;
                int productNameLength = 30;
                int priceLength = 8;
                int quantityLength = 4;
                String productName = args[1];
                String price = args[2];
                String quantity = args[3];
                String line = fileReader.readLine();
                String nextLine = "";
                if (line != null) nextLine = "\n";
                while (line != null) {
                    currentId = line.substring(0, idLength).trim();
                    if (Integer.parseInt(currentId) > maxId) {
                        maxId = Integer.parseInt(currentId);
                    }
                    line = fileReader.readLine();
                }
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
                StringBuilder dataToFile = new StringBuilder("");
                newId = String.valueOf(maxId + 1);
                recordMaker(idLength, newId, dataToFile);
                recordMaker(productNameLength, productName, dataToFile);
                recordMaker(priceLength, price, dataToFile);
                recordMaker(quantityLength, quantity, dataToFile);

                fileWriter.write(nextLine + dataToFile.toString());
                fileReader.close();
                fileWriter.close();
                break;
            case "-r" :
                break;
            case "-u" :
                break;
            case "-d" :
                break;
        }
    }
//-c Moloko 123 99
    private static void recordMaker(int fieldLength, String fieldName, StringBuilder dataToFile) {
        if (fieldName.length() >= fieldLength) {
            dataToFile.append(fieldName, 0, fieldLength);
        } else {
            dataToFile.append(fieldName);
            for (int i = 0; i < fieldLength - fieldName.length(); i++) {
                dataToFile.append(" ");
            }
        }
    }
}
