package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Player implements Movable{
    private int[] position;                 // the player's position is defined as a 2 digit array containing an x and y coordinate
    private int lampBattery;                // the lamp battery defines the number of moves the player has left

    public Player(int lampBattery){
        this.position = new int[] {0,0};    // the player starts the game in position 0.0
        this.lampBattery = lampBattery;
    }

    public void move(int x, int y){         // while the lamp battery is not 0 the player is able to move
        if (this.lampBattery > 0) {         // Since the player object is not aware of the dimensions of the dungeon as a whole,
            this.position[0] += x;          // the player is not responsible for ensuring that the passed movement is valid (ie not off the map)
            this.position[1] += y;          // that responsibly is delegated to the method caller (ie the map)
        } else {                            // when the lamp battery runs out, the method throws an exception that will be caught by the method caller signaling the end of the game
            throw new IllegalStateException();
        }
    }

    public void decreaseBattery(){
        this.lampBattery--;
    }

    public int[] returnCurrentPosition(){   // return the two digit array of the current position
        return this.position;
    }

    @Override
    public String toString(){               // The player will be represented by a '@' symbol on the map
        return "@";
    }

}
