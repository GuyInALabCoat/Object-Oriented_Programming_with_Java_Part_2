package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Exercise 16: Ski Jumping
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-09
 */

public class Judges {

    public int[] generateScores(){
        int[] scores = new int[5];          // Five judges vote for each jump (a random number between 10-20)
        Random random = new Random();
        int Low = 10;                       // inclusive
        int High = 21;                      // exclusive


        for(int i = 0; i < 5; i++ ){
            scores[i] = random.nextInt(High - Low) + Low;
        }

        return scores;
    }
}
