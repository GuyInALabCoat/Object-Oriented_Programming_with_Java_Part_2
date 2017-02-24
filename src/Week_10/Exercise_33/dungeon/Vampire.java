package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Vampire implements Movable{
    private int[] position = new int[2];

    public Vampire(int position[]){             // the vampires like the player are represented by a two digit array
        this.position = position;               // however, the position of the vampires is randomly generated at the beginning of the game
    }

    public void move(int x, int y){             // Similarly, like the player, the move method assumes that the passed move is valid and within the bounds of the larger grid
        this.position[0] += x;                  // the position of the vampire is updated by changing the values within the array. 0 is x and 1 is y.
        this.position[1] += y;
    }

    public int[] returnCurrentPosition(){       // return the current xy coordinates of the vampire
        return this.position;
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }

        if (( object == null ) || this.getClass() != object.getClass()){
            return false;
        }

        final Vampire vampire = (Vampire) object;

        return(this.position[0] == vampire.returnCurrentPosition()[0] && this.position[1] == vampire.returnCurrentPosition()[1]);
    }

    @Override
    public int hashCode(){
        int hash = 29;

        hash = 11 * hash + this.position[0];

        hash = 31 * hash + this.position[1];

        return hash;

    }
}
