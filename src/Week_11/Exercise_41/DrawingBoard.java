package Week_11.Exercise_41;

import java.awt.*;

import javax.swing.*;

/**
 * Exersice 41: Drawing Board
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

class DrawingBoard extends JPanel{

    DrawingBoard(){
        super.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics graphics){

        // paints a smiley face on the panel

        super.paintComponent(graphics);

        graphics.setColor(Color.BLACK);

        graphics.fillRect(100, 50, 50, 50);
        graphics.fillRect(250, 50, 50, 50);
        graphics.fillRect(50, 200, 50, 50);
        graphics.fillRect(100, 250, 200, 50);
        graphics.fillRect(300, 200, 50, 50);
    }
}
