package com.javarush.task.task13.task1308;

/* 
Эй, ты там живой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Human human = new Human();
        System.out.println(human.isAlive());
        System.out.println(human.isAnimal());
    }

    interface Person {
        boolean isAlive();
    }

    interface Pet {
        boolean isAnimal();
    }

    interface Presentable extends Person, Pet {

    }

    public static class Human implements Presentable {

        @Override
        public boolean isAlive() {
            return true;
        }

        @Override
        public boolean isAnimal() {
            return true;
        }
    }
}