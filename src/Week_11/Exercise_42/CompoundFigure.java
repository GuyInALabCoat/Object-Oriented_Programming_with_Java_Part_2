package Week_11.Exercise_42;

import java.util.ArrayList;
import java.awt.*;

/**
 * Exercise 42: A Moving Figure
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

public class CompoundFigure extends Figure{
    private ArrayList<Figure> figures;

    public CompoundFigure(){
        super(0,0);                             // default placeholder coordinate for the object
        this.figures = new ArrayList<>();
    }

    public void add(Figure figure){
        this.figures.add(figure);
    }

    @Override
    public void move(int dx, int dy){
        for (Figure figure : this.figures) {
            figure.move(dx, dy);
        }
    }

    public void draw(Graphics graphics){
        for (Figure figure : this.figures) {
            figure.draw(graphics);
        }
    }
}
