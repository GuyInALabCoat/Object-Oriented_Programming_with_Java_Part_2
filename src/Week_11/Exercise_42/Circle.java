package Week_11.Exercise_42;

import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

// An instance of a subclass of Figure that draws a circle at the position defined in its constructor
class Circle extends Figure{
    private int diameter;

    Circle(int x, int y, int diameter){

        super(x, y);

        this.diameter = diameter;
    }

    public void draw(Graphics graphics){
        graphics.fillOval(super.getX(), super.getY(), this.diameter, this.diameter);
    }

}
