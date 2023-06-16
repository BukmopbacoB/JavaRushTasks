package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0, "Test1");
        labels.put(1.1, "Test2");
        labels.put(1.2, "Test3");
        labels.put(1.3, "Test4");
        labels.put(1.4, "Test4");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}
