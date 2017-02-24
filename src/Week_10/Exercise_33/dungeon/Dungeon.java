package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Dungeon {
    private Map dungeonMap;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){
        dungeonMap = new Map(length, height, vampires, moves, vampiresMove);
    }

    public void run(){

    }
}
