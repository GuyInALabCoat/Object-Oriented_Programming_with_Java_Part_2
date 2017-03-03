package Week_11.Exercise_40;

import javax.swing.*;
import java.awt.*;
/**
 * Exercise 40: Calculator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-03
 */

// User interface that implements an addition and subtraction calculator
public class GraphicCalculator implements Runnable{
    private JFrame frame;

    // Standard JFrame setup
    @Override
    public void run(){
        frame = new JFrame("Calculator");
        frame.setPreferredSize(new Dimension(300, 200));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        frame.pack();

        frame.setVisible(true);

    }

    // Set up the window layout such that there is a text area for the output, input and a row of buttons on the bottom
    public void createComponents(Container container){
        container.setLayout(new GridLayout(3, 1));

        JTextField textOutput = new JTextField();
        JTextField textInput = new JTextField("0");

        textOutput.setEnabled(false);   // This text field is disabled for user input and only displays the output

        container.add(textOutput);
        container.add(textInput);
        container.add(getFrame());
    }

    // add the row of buttons to the inner JPanel which will be added to the larger container
    public JPanel getFrame(){
        JPanel panel = new JPanel(new GridLayout(1, 3));
        panel.add(new JButton("+"));
        panel.add(new JButton("-"));
        panel.add(new JButton("C"));
        return panel;

    }

    public static void main(String[] args){

        GraphicCalculator graphicCalc = new GraphicCalculator();
        SwingUtilities.invokeLater(graphicCalc);
    }
}
