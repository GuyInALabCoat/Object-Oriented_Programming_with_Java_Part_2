package com.company;

import java.util.ArrayList;

public class Container {
    private int maxWeight;
    private ArrayList<Suitcase> suitcases = new ArrayList<Suitcase>();
    private int currentWeight;

    public Container(int weightLimit){
        this.maxWeight = weightLimit;
        this.currentWeight = 0;
    }

    public void addSuitcase(Suitcase suitcase){
        if (this.maxWeight > this.currentWeight + suitcase.totalWeight()){
            this.suitcases.add(suitcase);
            this.currentWeight += suitcase.totalWeight();
        }
    }

    public String toString(){
        return this.suitcases.size() + " suitcases (" + this.currentWeight + " kg)";
    }

    public void printThings(){
        for (Suitcase suitcase:suitcases) {
            suitcase.printThings();
        }
    }

    public static void main(String[] args){
        Thing book = new Thing("Happiness in Three Steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        Thing brick = new Thing("Brick", 4);

        Suitcase tomsCase = new Suitcase(10);
        tomsCase.addThing(book);
        tomsCase.addThing(mobile);

        Suitcase georgesCase = new Suitcase(10);
        georgesCase.addThing(brick);

        Container container = new Container(1000);
        container.addSuitcase(tomsCase);
        container.addSuitcase(georgesCase);

        System.out.println("There are the following things in the container suitcases:");
        container.printThings();
    }
}
