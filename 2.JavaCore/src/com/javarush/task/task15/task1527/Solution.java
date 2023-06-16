package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        List<String> params = new ArrayList();
        params = Arrays.asList(url.substring(url.indexOf("?") + 1).split("&"));
        params.forEach(p -> System.out.print(p.replaceAll("=.+", "") + " "));
        System.out.println();
        params.forEach(p -> {
            if (p.startsWith("obj=")) {
                String value = p.substring(p.indexOf("=") + 1);
                try {
                    alert(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    alert(value);
                }
            }
        });
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
