package Week_11.Exercise_38.noticeboard;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 38: Notice Board
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

// class that creates the notice board window interface
class NoticeBoard implements Runnable{

    private JFrame frame;

    @Override
    public void run(){              // create a window of 400px x 300px and add the required components

        frame = new JFrame();
        frame.setPreferredSize(new Dimension(400, 300));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        GridLayout layout = new GridLayout(3, 1);       // configure the user interface to have 3 rows and 1 column
        container.setLayout(layout);                    // set this layout as the layout of the window

        JTextArea upperTextArea = new JTextArea();      // upperText area
        JTextArea lowerTextArea = new JTextArea();      // lowerText area
        JButton copyButton = new JButton("Copy!");      // Button that will sit in between the two areas

        ActionEventListener copier = new ActionEventListener(upperTextArea, lowerTextArea); // create an action event listener with references to the two text areas
        copyButton.addActionListener(copier);           // assign the action event listener to the button

        container.add(upperTextArea);                   // add the components to the window layout
        container.add(copyButton);
        container.add(lowerTextArea);

    }
}
