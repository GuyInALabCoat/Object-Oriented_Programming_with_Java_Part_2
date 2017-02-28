package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-19
 */

// Class defines a binary tuple that corresponds to an object's xy position.
class Position {
    int x;
    int y;

    Position(int x, int y){             // Constructor to set the initial xy position
        this.x = x;
        this.y = y;
    }

    int getXPos(){                      // return the object's current x position
        return this.x;
    }

    int getYPos(){                      // return the object's current y position
        return this.y;
    }
}
