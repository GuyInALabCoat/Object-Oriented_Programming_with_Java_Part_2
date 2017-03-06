package Week_11.Exercise_42;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */
public class KeyboardListener implements KeyListener{

    private Component component;
    private Figure figure;

    public KeyboardListener(Component component, Figure figure){
        this.component = component;
        this.figure = figure;
    }

    @Override
    public void keyPressed(KeyEvent event){

        if (event.getKeyCode() == KeyEvent.VK_LEFT){
            this.figure.move(-1, 0);
        } else if (event.getKeyCode() == KeyEvent.VK_RIGHT){
            this.figure.move(1, 0);
        } else if (event.getKeyCode() == KeyEvent.VK_UP){
            this.figure.move(0, -1);
        } else if (event.getKeyCode() == KeyEvent.VK_DOWN){
            this.figure.move(0, 1);
        }

        component.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e){

    }

    @Override
    public void keyTyped(KeyEvent e){

    }
}
