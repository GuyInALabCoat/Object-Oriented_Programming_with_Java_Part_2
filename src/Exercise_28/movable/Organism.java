package Exercise_28.movable;

/**
 * Object-Oriented Programming with Java Part 2 : 2017-02-04
 */

public class Organism implements Movable{
    private int positionX;
    private int positionY;

    public Organism(int x, int y){
        this.positionX = x;
        this.positionY = y;
    }

    public int getPositionX(){
        return this.positionX;
    }

    public int getPositionY(){
        return this.positionY;
    }

    @Override
    public String toString(){                   // creates a String to represent the position of the organism
        return "x: " + getPositionX() + "; y: " + getPositionY();
    }

    @Override
    public void move(int dx, int dy) {          // moves the organism by the amount specified in the arguements
        this.positionX += dx;                   // the variable dx contains the x coordinate of movement
        this.positionY += dy;                   // the variable dy contains the y coordinate of movement
    }

    public static void main(String[] args){
        Organism organism = new Organism(20, 30);
        System.out.println(organism);
        organism.move(-10, 5);
        System.out.println(organism);
        organism.move(50, 20);
        System.out.println(organism);
    }
}
