package com.company;

import java.util.ArrayList;
import java.util.Random;

/**
 * Exercise 16: Ski Jumping
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-09
 */

public class Jumper implements Comparable<Jumper>{
    private String name;
    private int totalScore;
    private ArrayList<Integer> jumpLengths;

    public Jumper(String name){
        this.name = name;
        this.totalScore = 0;
        jumpLengths = new ArrayList<>();
    }

    public String getName(){
        return this.name;
    }

    public int getTotalScore(){
        return this.totalScore;
    }

    public void addToScore(int score){
        this.totalScore += score;
    }

    @Override
    public String toString(){
        return this.getName() + " (" + this.getTotalScore() + " points)";
    }

    @Override
    public int compareTo(Jumper jumper){                        // Used by Collections.sort to sort jumpers by increasing total scores
        return this.getTotalScore() - jumper.getTotalScore();
    }

    public int jump(){                                          // jump length (a random integer between 60-120)
        Random random = new Random();
        int Low = 60;
        int High = 121;
        int length = random.nextInt(High - Low) + Low;
        jumpLengths.add(length);
        return length;
    }

    public ArrayList<Integer> jumpList(){
        return jumpLengths;
    }

}
