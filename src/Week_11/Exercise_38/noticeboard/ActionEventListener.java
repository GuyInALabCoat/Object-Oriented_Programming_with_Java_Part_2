package Week_11.Exercise_38.noticeboard;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exercise 38: Notice Board
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

// class that implements the interface ActionListener to copy text from one text field to another upon event trigger
class ActionEventListener implements ActionListener{

    private JTextArea origin;                       // text field to take text from
    private JTextArea destination;                  // text field to copy text to

    ActionEventListener(JTextArea origin, JTextArea destination){       // create the object with references to both text fields
        this.origin = origin;
        this.destination = destination;
    }

    @Override
    public void actionPerformed(ActionEvent ae){                        // upon event trigger
        this.destination.setText(this.origin.getText());                // fill the destination text field with text from the origin
        this.origin.setText("");                                        // erase all text from the origin
    }
}
