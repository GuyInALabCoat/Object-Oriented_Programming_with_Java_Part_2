package Exercise_28.movable;

import java.util.ArrayList;
import java.util.List;

/**
 * Object-Oriented Programming with Java Part 2 : 2017-02-04
 */

public class Group implements Movable{
    private List<Movable> groupList;

    public Group(){
        groupList = new ArrayList<Movable>();                   // Group objects store objects which implement the interface Movable to an arrayList
    }

    @Override
    public String toString(){
        StringBuilder newString = new StringBuilder();

        for (Movable moveable : this.groupList) {               // for each object in the groupList
            newString.append(moveable.toString()).append("\n"); // get the string representation of the object and add a newline character and append it to a new String
        }

        return newString.toString();                            // return the string in which each object will be printed on a separate line
    }

    public void addToGroup(Movable movable){                    // add Movable object to the list
        this.groupList.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable movable : groupList) {                     // for each object in the list, move the object by the specified parameters
            movable.move(dx, dy);                               // this emulates how the group would move as a whole
        }
    }

    public static void main(String[] args){
        Group group = new Group();
        group.addToGroup(new Organism(73, 56));
        group.addToGroup(new Organism(57, 66));
        group.addToGroup(new Organism(46, 52));
        group.addToGroup(new Organism(19, 107));
        System.out.println(group);
    }
}
