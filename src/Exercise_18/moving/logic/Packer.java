package Exercise_18.moving.logic;

import Exercise_18.moving.domain.Box;
import Exercise_18.moving.domain.Item;
import Exercise_18.moving.domain.Thing;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 18: Moving
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class Packer {
    private int maxBoxVolume;

    public Packer(int boxesVolume){
        this.maxBoxVolume = boxesVolume;
    }

    public List<Box> packThings(List<Thing> things){
        List<Box> boxes = new ArrayList<Box>();

        int iterator = 0;

        if (!(things.isEmpty())){

            for (Thing object: things) {
                if (boxes.isEmpty()){                           // if the ArrayList is empty, create new Box object at iterator position.
                    boxes.add(new Box(this.maxBoxVolume));
                    boxes.get(iterator).addThing(object);
                } else if (!(boxes.get(iterator).addThing(object))) {       // item is implicitly added to the current box by addThing method if it fits into the box
                    boxes.add(new Box(this.maxBoxVolume));      // if the current Box is full, and new Box and move iterator.
                    iterator++;
                    boxes.get(iterator).addThing(object);       // add item to new box

                                                                // Warning: will crash if trying to add item larger than maximum box volume.
                                                                // ArrayList will grow indefinitely until no more available memory is left.
                }
            }

        }

        return boxes;
    }

    public static void main(String[] args){
        // Exercise 18.4 Packing Items

        // the things we want to pack
        List<Thing> things = new ArrayList<Thing>();
        things.add(new Item("passport", 2));
        things.add(new Item("toothbrush", 1));
        things.add(new Item("book", 4));
        things.add(new Item("circular saw", 8));

        // we create a packer which uses boxes whose volume is 10
        Packer packer = new Packer(10);

        // we ask our packer to pack things into boxes
        List<Box> boxes = packer.packThings(things);

        System.out.println("number of boxes: " + boxes.size());

        for (Box box : boxes){
            System.out.println(" things in the box: " + box.getVolume() + " dm^3");
        }
    }
}
