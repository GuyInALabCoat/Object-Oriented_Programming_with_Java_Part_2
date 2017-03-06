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

        CompoundFigure truck = new CompoundFigure();

        truck.add(new Box(220, 110, 75, 100));
        truck.add(new Box(80, 120, 200, 100));
        truck.add(new Circle(100, 200, 50));
        truck.add(new Circle(220, 200, 50));

        UserInterface ui = new UserInterface(truck);
        SwingUtilities.invokeLater(ui);
    }
}
