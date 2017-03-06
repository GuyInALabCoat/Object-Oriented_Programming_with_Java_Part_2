package Week_11.Exercise_42;

import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

// abstract class that defines figures which must have an x and y components, be able to move and draw themselves
public abstract class Figure {

    private int x;
    private int y;

    public Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public abstract void draw(Graphics graphics);

}
