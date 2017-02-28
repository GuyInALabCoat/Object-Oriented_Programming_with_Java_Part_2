package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

class Player implements Movable{
    private Position position;              // Tuple position object to define the coordinates of the player
    private int lampBattery;                // the lamp battery defines the number of moves the player has left

    Player(int lampBattery){                // The player starts at position 0,0 of the map
        position = new Position(0,0);
        this.lampBattery = lampBattery;
    }

    public void move(int x, int y){         // while the lamp battery is not 0 the player is able to move
        if (this.lampBattery > 0) {         // Since the player object is not aware of the dimensions of the dungeon as a whole,
            this.position.x += x;            // the player is not responsible for ensuring that the passed movement is valid (ie not off the map)
            this.position.y += y;            // that responsibly is delegated to the method caller (ie the map)
            decreaseBattery();
        } else {                            // when the lamp battery runs out, the method throws an exception that will be caught by the method caller signaling the end of the game
            throw new IllegalStateException();
        }
    }

    private void decreaseBattery(){
        this.lampBattery--;
    }

    public Position returnCurrentPosition(){    // implement method of interface that returns the player's current position
        return this.position;
    }

    int getLampBattery(){
        return this.lampBattery;
    }

    @Override
    public String toString(){
        return "@ " + this.returnCurrentPosition().getXPos() + " " + this.returnCurrentPosition().getYPos();
    }

}
