package com.company;

import java.util.ArrayList;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-27
 */

public class Box implements ToBeStored{
    private double maxWeight;
    // Interface as a parameter
    private ArrayList<ToBeStored> things;   // so long as objects implement the interface ToBeStored, they can be stored in the Array List


    public Box(double maxWeight){
        this.maxWeight = maxWeight;
        things = new ArrayList<ToBeStored>();
    }

    // calculates the weight of the box based on the weights of the things stored within
    public double weight(){
        double weight = 0;
        for (ToBeStored item: things) {
            weight += item.weight();
        }
        return weight;
    }

    public void add(ToBeStored item){
        if (this.weight() + item.weight() <= this.maxWeight){
            this.things.add(item);  // so long as the current weight of the box + weight of item < max weight of box, add item
        }
    }

    public String toString(){
        return "Box: " + this.things.size() + " things, total weight " + this.weight() + " kg";
    }

    public static void main(String[] args){
        Box box = new Box(10);

        box.add(new Book("Fedor Dostojevski", "Crime and Punishment", 2));
        box.add(new Book("Robert Martin", "Clean Code", 1));
        box.add(new Book("Kent Beck", "Test Driven Development", 0.7));

        box.add(new CD("Pink Floyd", "Dark Side of the Moon", 1973));
        box.add(new CD("Wigwam", "Nuclear Nightclub", 1975));
        box.add(new CD("Rendezvous Park", "Closer to Being Here", 2012));

        System.out.println(box);

        Box box2 = new Box(12);

        box2.add(new Book("Michael Spiser", "Introduction to the Theory of Computation", 1.5));
        box2.add(box);

        System.out.println(box2);

//      box2.add(box2);               Causes a StackOverflowError because the method weight enters an infinite loop.
//      System.out.println(box2);
    }
}
