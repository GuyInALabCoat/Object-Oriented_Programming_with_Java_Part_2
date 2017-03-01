package Week_11.Exercise_37;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 37: Survey
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-28
 */

// Creates simple user interface with checkboxes
public class Survey implements Runnable{

    private JFrame frame;

    public Survey(){

    }

    @Override
    public void run(){

        frame = new JFrame("Survey");                                   // Title
        frame.setPreferredSize(new Dimension(200, 300));                // 200px x 300px

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  // Close by hitting the red X

        createComponents(frame.getContentPane());                       // add components to the frame

        frame.pack();
        frame.setVisible(true);

    }

    private void createComponents(Container container){

        BoxLayout layout = new BoxLayout(container, BoxLayout.Y_AXIS);  // arrange components on the vertical axis
        container.setLayout(layout);                                    // set BoxLayout as the layout of the frame

        container.add(new JLabel("Are you?"));

        JCheckBox Yes = new JCheckBox("Yes!");                          // create a checkbox for yes
        JCheckBox No = new JCheckBox("No!");                            // create a checkbox for no

        ButtonGroup yesNo = new ButtonGroup();                          // make the buttons mutually exclusive
        yesNo.add(Yes);
        yesNo.add(No);

        container.add(Yes);                                             // Add both buttons to the frame
        container.add(No);

        container.add(new JLabel("Why?"));

        JRadioButton noReason = new JRadioButton("No reason.");         // create two new buttons
        JRadioButton fun = new JRadioButton("Because it is fun!");

        ButtonGroup why = new ButtonGroup();                            // Make them mutually exclusive as well
        why.add(noReason);
        why.add(fun);

        container.add(noReason);                                        // Add them to the frame as well
        container.add(fun);

        container.add(new JButton("Done!"));                             // Add a button at the bottom called "Done"

    }

    public static void main(String[] args){
        Survey survey = new Survey();
        SwingUtilities.invokeLater(survey);
    }
}
