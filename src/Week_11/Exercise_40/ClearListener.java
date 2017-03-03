package Week_11.Exercise_40;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Exercise 40: Calculator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-03
 */

// ActionListener that upon trigger, sets the output text field to 0
class ClearListener implements ActionListener{
    private JTextField output;

    ClearListener(JTextField output){
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        this.output.setText("0");

    }

}
