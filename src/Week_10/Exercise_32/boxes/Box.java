package Week_10.Exercise_32.boxes;

import java.util.Collection;

/**
 * Exercise 32: Different Boxes
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public abstract class Box {

    public abstract void add(Thing thing);

    public void add(Collection<Thing> things){
        for (Thing thing : things) {
            add(thing);
        }
    }

    public abstract boolean isInTheBox(Thing thing);
}
