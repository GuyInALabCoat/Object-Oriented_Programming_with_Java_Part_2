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
    private JButton clearButton;

    AdditionListener(JTextField input, JTextField output, JButton clearButton){
        this.input = input;
        this.output = output;
        this.clearButton = clearButton;
    }

    @Override
    public void actionPerformed(ActionEvent event){


        try {
            int input = Integer.parseInt(this.input.getText());

            int output = Integer.parseInt(this.output.getText());

            this.output.setText(Integer.toString(input + output));

            this.input.setText("");

            if (this.output.getText().equals("0")){
                this.clearButton.setEnabled(false);         // disable the clear button if the output equals 0
            } else {
                this.clearButton.setEnabled(true);          // else enable it
            }

        } catch (Exception e){                              // if the input is not a number, clear the input
            this.input.setText("");
        }
    }
}
