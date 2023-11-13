package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Прайсы 2
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[0].startsWith("-")) return;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();
        int idLength = 8;
        int productNameLength = 30;
        int priceLength = 8;
        int quantityLength = 4;
        StringBuilder dataToFile = new StringBuilder("");
        String id;
        String productName;
        String price;
        String quantity;
        String line;
        String nextLine;

        switch (args[0]) {
            case "-c" :
                BufferedReader fileReader = new BufferedReader(new FileReader(file));
                String newId;
                String currentId;
                int maxId = 0;

                productName = args[1];
                price = args[2];
                quantity = args[3];
                line = fileReader.readLine();
                nextLine = (line == null) ? "" : System.lineSeparator();
                while (line != null) {
                    currentId = line.substring(0, idLength).trim();
                    if (Integer.parseInt(currentId) > maxId) {
                        maxId = Integer.parseInt(currentId);
                    }
                    line = fileReader.readLine();
                }
                BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, true));
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
                // -u 12345680 Bread 87654321 4321
                fileReader = new BufferedReader(new FileReader(file));
                dataToFile = new StringBuilder("");
                id = args[1];
                productName = args[2];
                price = args[3];
                quantity = args[4];
                line = fileReader.readLine();
                nextLine = "";
                while (line != null) {
                    if (id.equals(line.substring(0, idLength).trim())) {
                        dataToFile.append(nextLine);
                        recordMaker(idLength, id, dataToFile);
                        recordMaker(productNameLength, productName, dataToFile);
                        recordMaker(priceLength, price, dataToFile);
                        recordMaker(quantityLength, quantity, dataToFile);
                    } else {
                        dataToFile.append(nextLine + line);
                    }
                    nextLine = System.lineSeparator();
                    line = fileReader.readLine();
                }
                fileWriter = new BufferedWriter(new FileWriter(file));
                fileWriter.write(dataToFile.toString());
                fileReader.close();
                fileWriter.close();
                break;
            case "-d" :
                // -d 12345680
                fileReader = new BufferedReader(new FileReader(file));
                dataToFile = new StringBuilder("");
                id = args[1];
                line = fileReader.readLine();
                nextLine = "";
                while (line != null) {
                    if (!(id.equals(line.substring(0, idLength).trim()))) {
                        dataToFile.append(nextLine + line);
                    }
                    nextLine = System.lineSeparator();
                    line = fileReader.readLine();
                }
                fileWriter = new BufferedWriter(new FileWriter(file));
                fileWriter.write(dataToFile.toString());
                fileReader.close();
                fileWriter.close();
                break;
        }
    }

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
