package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

// Interface defines the objects in the game that are able to move, i.e. the player and the vampires
public interface Movable {

    // This definition states that objects that are movable must implement a method that allows them to move on an xy grid
    public void move(int x, int y);

    // These objects must also be able to return their current position to the caller
    public int[] returnCurrentPosition();
}
