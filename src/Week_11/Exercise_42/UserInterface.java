package Week_11.Exercise_42;

import javax.swing.*;
import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

public class UserInterface implements Runnable{

    private JFrame frame;
    private Figure figure;

    public UserInterface(Figure figure){
        this.figure = figure;
    }

    @Override
    public void run(){
        this.frame = new JFrame();

        this.frame.setPreferredSize(new Dimension(400, 400));

        this.frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createComponents(frame.getContentPane());

        this.frame.pack();

        this.frame.setVisible(true);
    }

    private void createComponents(Container container){
        DrawingBoard drawingBoard = new DrawingBoard(this.figure);
        container.add(drawingBoard);

        this.frame.addKeyListener(new KeyboardListener(drawingBoard, this.figure));
    }

    public static void main(String[] args){

        UserInterface ui = new UserInterface(new Circle(50, 50, 250));
        SwingUtilities.invokeLater(ui);
    }
}
