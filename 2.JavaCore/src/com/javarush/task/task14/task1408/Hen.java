package com.javarush.task.task14.task1408;

public abstract class Hen {
    public abstract int getCountOfEggsPerMonth();

    public int countEggs;

    public String getDescription() {
        return "Я - курица.";
    }
}
