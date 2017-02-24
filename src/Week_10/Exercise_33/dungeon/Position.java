package Week_10.Exercise_33.dungeon;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-19
 */

public class Position<X, Y> {
    public X x;
    public Y y;

    public Position(X x, Y y){
        this.x = x;
        this.y = y;
    }

    public X getXPos(){
        return this.x;
    }

    public Y getYPos(){
        return this.y;
    }

    public static void main(String[] args){
        Position position = new Position<>(3, 4);

        System.out.println(position.getXPos() + ", " + position.getYPos());
    }
}
