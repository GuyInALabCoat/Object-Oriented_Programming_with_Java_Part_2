package Week_11.Exercise_42;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

class DrawingBoard extends JPanel{
    private Figure figure;

    DrawingBoard(Figure figure){
        super.setBackground(Color.WHITE);
        this.figure = figure;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);

        this.figure.draw(g);
    }
}
