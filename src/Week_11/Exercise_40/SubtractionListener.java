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
    private JButton clearButton;

    SubtractionListener(JTextField input, JTextField output, JButton clearButton){
        this.input = input;
        this.output = output;
        this.clearButton = clearButton;
    }

    @Override
    public void actionPerformed(ActionEvent event){

        try {
            int input = Integer.parseInt(this.input.getText());
            int output = Integer.parseInt(this.output.getText());

            this.output.setText(Integer.toString(output - input));

            this.input.setText("");

            if (this.output.getText().equals("0")) {            // if the output equals 0, disable the clear button
                this.clearButton.setEnabled(false);
            } else {
                this.clearButton.setEnabled(true);              // else enable it
            }

        } catch (Exception e){                                  // if the input is not a number, clear the input
            this.input.setText("");
        }
    }
}
