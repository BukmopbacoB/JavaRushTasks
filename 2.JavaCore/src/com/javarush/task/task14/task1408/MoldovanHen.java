package com.javarush.task.task14.task1408;

public class MoldovanHen extends Hen implements Country {
    @Override
    public int getCountOfEggsPerMonth() {
        return countEggs;
    }

    public String getDescription() {
        return super.getDescription() + " Моя страна - " +
                Country.MOLDOVA + ". Я несу " + countEggs + " яиц в месяц.";
    }
}
