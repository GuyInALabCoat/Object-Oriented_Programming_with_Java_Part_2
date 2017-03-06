package Week_11.Exercise_41;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 41: Drawing Board
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

// creates a window interface that is 400 x 400 px. The Drawing board instance paints a smiley face on the panel
public class UserInterface implements Runnable {

    public UserInterface(){

    }

    @Override
    public void run(){
        JFrame frame = new JFrame();

        frame.setPreferredSize(new Dimension(400, 400));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){

        container.add(new DrawingBoard());
    }

    public static void main(String[] args){

        UserInterface ui = new UserInterface();

        SwingUtilities.invokeLater(ui);
    }
}
