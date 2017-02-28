package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

class Vampire implements Movable{
    private Position position;                  // Binary Tuple object to record the vampire's current position

    Vampire(int xPosition, int yPosition){      // Constructor to define a vampire's starting position
        position = new Position(xPosition, yPosition);
    }

    public void move(int x, int y){             // Similarly, like the player, the move method assumes that the passed move is valid and within the bounds of the larger grid
        this.position.x += x;
        this.position.y += y;
    }

    public Position returnCurrentPosition(){    // implement the method of the interface to return the vampire's current position
        return this.position;
    }

    @Override
    public String toString(){
        return "v " + this.returnCurrentPosition().getXPos() + " " + this.returnCurrentPosition().getYPos();
    }

    @Override
    public boolean equals(Object object){       // New equals method that compares two vampires and returns true if they are on the same xy coordinate
        if (this == object){
            return true;
        }

        if (( object == null ) || this.getClass() != object.getClass()){
            return false;
        }

        final Vampire vampire = (Vampire) object;

        return(this.position.getXPos() == vampire.position.getXPos() && this.position.getYPos() == vampire.position.getYPos());
    }

    @Override
    public int hashCode(){                      // New hashcode method that returns an integer value of the vampire's position
        int hash = 29;

        hash = 11 * hash + this.position.getXPos();

        hash = 31 * hash + this.position.getYPos();

        return hash;

    }
}
