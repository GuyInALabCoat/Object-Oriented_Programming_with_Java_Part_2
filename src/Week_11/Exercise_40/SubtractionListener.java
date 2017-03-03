package Week_11.Exercise_40;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Exercise 40: Calculator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-03
 */

// ActionListener that upon trigger, subtracts the input from the output
class SubtractionListener implements ActionListener{

    private JTextField input;
    private JTextField output;

    SubtractionListener(JTextField input, JTextField output){
        this.input = input;
        this.output = output;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        int input = Integer.parseInt(this.input.getText());
        int output = Integer.parseInt(this.output.getText());

        this.output.setText(Integer.toString(output - input));

    }
}
