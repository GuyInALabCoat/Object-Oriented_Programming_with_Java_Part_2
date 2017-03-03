package Week_11.Exercise_40;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Exercise 40: Calculator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-03
 */

// ActionListener that upon trigger takes the input and adds it to the output
class AdditionListener implements ActionListener{
    private JTextField input;
    private JTextField output;

    AdditionListener(JTextField input, JTextField output){
        this.input = input;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        int input = Integer.parseInt(this.input.getText());
        int output = Integer.parseInt(this.output.getText());

        this.output.setText(Integer.toString(input + output));
    }
}
