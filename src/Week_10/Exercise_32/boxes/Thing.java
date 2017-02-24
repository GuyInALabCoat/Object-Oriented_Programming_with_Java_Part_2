package Exercise_32.boxes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 32: Different Boxes
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Thing {
    private String name;
    private int weight;

    public Thing(String name, int weight){
        this.name = name;

        if (weight >= 0){
            this.weight = weight;
        } else {
            throw new IllegalArgumentException("A thing's weight cannot be less than 0.");
        }
    }

    public Thing(String name) {
        this.name = name;
    }

    public int getWeight(){
        return this.weight;
    }

    @Override
    public boolean equals(Object object){
        if (object == null){
            return false;
        }

        if (this.getClass() != object.getClass()){
            return false;
        }

        Thing comparedThing = (Thing) object;

        if (!(this.name.equals(comparedThing.name))){
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        if (this.name == null){
            return - 1;
        }

        return this.name.hashCode();
    }
}

