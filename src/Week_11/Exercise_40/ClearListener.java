package Week_11.Exercise_40;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Exercise 40: Calculator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-03
 */

// ActionListener that upon trigger, sets the output text field to 0 and clears the input field
class ClearListener implements ActionListener{
    private JTextField input;
    private JTextField output;

    ClearListener(JTextField input, JTextField output){
        this.input = input;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        this.input.setText("");
        this.output.setText("0");

    }

}
