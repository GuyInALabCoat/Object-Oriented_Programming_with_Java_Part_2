package Week_11.Exercise_42;

import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

// abstract class that defines figures which must have an x and y components, be able to move and draw themselves
abstract class Figure {

    private int x;
    private int y;

    Figure(int x, int y){
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy){
        this.x += dx;
        this.y += dy;
    }

    int getX(){
        return this.x;
    }

    int getY(){
        return this.y;
    }

    public abstract void draw(Graphics graphics);

}
