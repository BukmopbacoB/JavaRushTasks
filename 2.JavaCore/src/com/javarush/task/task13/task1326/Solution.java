package com.javarush.task.task13.task1326;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        Scanner scanner = new Scanner(new FileInputStream(sourceFileName));

        List<Integer> data = new ArrayList<>();
        while (scanner.hasNext()) {
            int value = scanner.nextInt();
            if (value % 2 == 0) data.add(value);
        }

        Collections.sort(data);
        for (Integer value : data) {
            System.out.println(value);
        }

        scanner.close();

//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String pathFile = reader.readLine();
//        List<String> allInteger = Files.readAllLines(Path.of(pathFile));
//        List<Integer> newList = allInteger.stream().
//                map(Integer::parseInt).filter(n -> (n % 2) == 0).
//                sorted(Comparator.comparingInt(a -> a)).
//                collect(Collectors.toList());
//        newList.forEach(System.out::println);
//        reader.close();
    }
}
