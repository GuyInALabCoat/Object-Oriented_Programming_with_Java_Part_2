package Week_11.Exercise_42;

import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

// A subclass of the Figure class that creates a square given a position and a side length
public class Square extends Figure{
    private int sideLength;

    public Square(int x, int y, int sideLength){
        super(x, y);
        this.sideLength = sideLength;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), this.sideLength, this.sideLength);
    }
}
