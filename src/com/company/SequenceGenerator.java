package com.company;

import java.util.Random;

public class SequenceGenerator {

    public static void main(String[] args){
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();

        String[] sampleArray = {"A", "C", "G", "T"};

        for (int i = 0; i < 20; i++){
            stringBuilder.append(sampleArray[random.nextInt(4)]);
        }

        String finalString = stringBuilder.toString();
        System.out.println(finalString);
    }
}
