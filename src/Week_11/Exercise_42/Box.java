package Week_11.Exercise_42;

import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */
public class Box extends Figure{
    private int width;
    private int height;

    public Box(int x, int y, int width, int height){
        super(x, y);

        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.fillRect(super.getX(), super.getY(), this.width, this.height);
    }
}
