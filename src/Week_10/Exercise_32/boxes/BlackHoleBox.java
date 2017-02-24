package Exercise_32.boxes;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 32: Different Boxes
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class BlackHoleBox extends Box{
    private List<Thing> thingList;

    public BlackHoleBox(){
        thingList = new ArrayList<Thing>();
    }

    @Override
    public void add(Thing thing){

    }

    @Override
    public boolean isInTheBox(Thing thing){
        return this.thingList.contains(thing);
    }

    public static void main(String[] args){
        // Exercise 32.4 Black-Hole Box
        BlackHoleBox box = new BlackHoleBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkka")));
    }
}
