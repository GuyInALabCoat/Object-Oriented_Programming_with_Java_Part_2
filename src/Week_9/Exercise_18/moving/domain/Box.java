package Week_9.Exercise_18.moving.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 18: Moving
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class Box implements Thing{
    private int currentVolume;
    private final int maximumCapacity;
    private List<Thing> items;

    public Box(int maximumCapacity){
        this.maximumCapacity = maximumCapacity;
        this.currentVolume = 0;
        this.items = new ArrayList<Thing>();
    }

    public boolean addThing(Thing thing){
        if (this.getVolume() + thing.getVolume() <= this.maximumCapacity){
            items.add(thing);
            currentVolume += thing.getVolume();
            return true;
        } else {
            return false;
        }
    }

    public int getVolume(){
        return this.currentVolume;
    }
}
