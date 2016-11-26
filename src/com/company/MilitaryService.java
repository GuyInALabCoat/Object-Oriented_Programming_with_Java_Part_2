package com.company;

/**
 Object-Oriented Programming with Java Part 2
 */

public class MilitaryService implements NationalService{
        private int daysLeft;

    public MilitaryService(int daysLeft){
        this.daysLeft = daysLeft;
    }

    public int getDaysLeft(){
        return this.daysLeft;
    }

    public void work(){
        if(this.getDaysLeft() != 0){
            this.daysLeft--;
        }
    }
}
