package com.company;

import java.util.ArrayList;

public class Suitcase {
    private ArrayList<Thing> things = new ArrayList<Thing>();
    private int maxWeight;

    public Suitcase(int weight){
        this.maxWeight = weight;
    }

    public void addThing(Thing thing){
        if (this.maxWeight >= (this.totalWeight() + thing.getWeight())) {
            this.things.add(thing);
        }
    }

    public String toString(){
        if (things.size() == 0){
            return "empty (" + this.totalWeight() + " kg)";
        } else if (things.size() == 1) {
            return things.size() + " thing (" + this.totalWeight() + " kg)";
        } else {
            return things.size() + " things (" + this.totalWeight() + " kg)";
        }
    }

    public void printThings(){
        for (Thing thing:things) {
            System.out.println(thing);
        }
    }

    public int totalWeight(){
        int sum = 0;
        for (Thing thing:things) {
            sum += thing.getWeight();
        }
        return sum;
    }

    public Thing heaviestThing(){
        Thing heaviest = new Thing("thing", 0);

        if (this.things.size() == 0){
            return null;
        } else {
            for (Thing thing:things) {
                if (thing.getWeight() >= heaviest.getWeight()){
                    heaviest = thing;
                }
            }
        }
        return heaviest;
    }

    public static void main(String[] args){
        Thing book = new Thing("Happiness in Three Steps", 2);
        Thing mobile = new Thing("Nokia 3210", 1);
        Thing brick = new Thing("Brick", 4);

        Suitcase suitcase = new Suitcase(10);
        suitcase.addThing(book);
        suitcase.addThing(mobile);
        suitcase.addThing(brick);

        Thing heaviest = suitcase.heaviestThing();
        System.out.println("The heaviest thing: " + heaviest);
    }

}
