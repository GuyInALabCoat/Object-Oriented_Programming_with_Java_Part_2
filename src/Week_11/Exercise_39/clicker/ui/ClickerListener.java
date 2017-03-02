package Week_11.Exercise_39.clicker.ui;

import Week_11.Exercise_39.clicker.applicationlogic.Calculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Exercise 39: Axe Click Effect
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

public class ClickerListener implements ActionListener{
    private Calculator calculator;
    private JLabel label;

    public ClickerListener(Calculator calculator, JLabel label){
        this.calculator = calculator;
        this.label = label;
    }

    @Override
    public void actionPerformed(ActionEvent ae){
        this.calculator.increase();
        label.setText(Integer.toString(this.calculator.giveValue()));
    }
}
