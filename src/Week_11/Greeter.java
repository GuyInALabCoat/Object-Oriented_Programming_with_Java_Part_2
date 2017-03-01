package Week_11;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 36: Greeter
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-28
 */

public class Greeter implements Runnable{

    private JFrame frame;

    public Greeter(){

    }

    @Override
    public void run(){

        frame = new JFrame("Swing on");
        frame.setPreferredSize(new Dimension(400, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        JLabel text = new JLabel("Hi");
        container.add(text);
    }

    public static void main(String[] args){
        Greeter greeter = new Greeter();
        SwingUtilities.invokeLater(greeter);
    }
}
