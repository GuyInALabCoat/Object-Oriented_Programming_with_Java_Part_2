package Exercise_32.boxes;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 32: Different Boxes
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class MaxWeightBox extends Box{
    private int boxMaxWeight;
    private int currentWeight;
    private List<Thing> thingList;

    public MaxWeightBox(int maxWeight){
        this.boxMaxWeight = maxWeight;
        this.currentWeight = 0;
        thingList = new ArrayList<Thing>();
    }

    @Override
    public void add (Thing thing){
        if (this.currentWeight + thing.getWeight() <= this.boxMaxWeight){
            thingList.add(thing);
            this.currentWeight += thing.getWeight();
        }
    }

    @Override
    public boolean isInTheBox(Thing thing){
        return this.thingList.contains(thing);
    }

    public static void main(String[] args){
        // 32.2 Maximum Weight Box
        MaxWeightBox coffeeBox = new MaxWeightBox(10);
        coffeeBox.add(new Thing("Saludo", 5));
        coffeeBox.add(new Thing("Pirkka", 5));
        coffeeBox.add(new Thing("Kopi Luwak", 5));

        System.out.println(coffeeBox.isInTheBox(new Thing("Saludo")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Pirkka")));
        System.out.println(coffeeBox.isInTheBox(new Thing("Kopi Luwak")));
    }
}
