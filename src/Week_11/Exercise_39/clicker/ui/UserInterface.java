package Week_11.Exercise_39.clicker.ui;

import Week_11.Exercise_39.clicker.applicationlogic.Calculator;
import Week_11.Exercise_39.clicker.applicationlogic.PersonalCalculator;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 39: Axe Click Effect
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

// User interface that displays a value and a button to increment the value
public class UserInterface implements Runnable{
    private JFrame frame;
    private Calculator calculator;

    public UserInterface(Calculator calculator){
        this.calculator = calculator;               // the current value is held by calculator object
    }

    // Standard window set up
    @Override
    public void run(){
        frame = new JFrame("Click Effect");
        frame.setPreferredSize(new Dimension(200, 100));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }

    private void createComponents(Container container){
        container.setLayout(new BorderLayout());

        JButton clicker = new JButton("Click!");                // button to trigger action listener
        JLabel textValue = new JLabel(Integer.toString(this.calculator.giveValue()));   // set the label to the current calculator value which by default is 0

        ClickerListener listener = new ClickerListener(this.calculator, textValue);     // create new action listener object with references to the calculator and the text label
        clicker.addActionListener(listener);                    // upon click, the calculator will be incremented and the label changed to the new value

        container.add(textValue);                               // add the label and the button to the window
        container.add(clicker, BorderLayout.SOUTH);

    }

    // Launch the user interface.
    public static void main(String[] args){
        Calculator calc = new PersonalCalculator();
        UserInterface ui = new UserInterface(calc);
        SwingUtilities.invokeLater(ui);
    }
}
