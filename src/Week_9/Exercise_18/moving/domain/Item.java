package Week_9.Exercise_18.moving.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 18: Moving
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class Item implements Thing, Comparable<Item> {
    private String name;
    private int volume;

    public Item(String name, int volume){
        this.name = name;
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return this.getName() + " (" + this.getVolume() + " dm^3)";
    }

    public int compareTo(Item item){
        return this.getVolume() - item.getVolume();
    }

    public static void main(String[] args){
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("passport", 2));
        items.add(new Item("toothbrush", 1));
        items.add(new Item("circular saw", 100));

        Collections.sort(items);
        System.out.println(items);
    }
}
