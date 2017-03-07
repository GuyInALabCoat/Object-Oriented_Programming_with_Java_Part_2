package Week_11.Exercise_43.game;

import gameoflife.GameOfLifeBoard;

import java.util.Random;

/**
 * Exercise 43: Game Of Life
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-06
 */

public class PersonalBoard extends GameOfLifeBoard{

    public PersonalBoard(int width, int height){
        super(width, height);
    }

    @Override
    public void turnToLiving(int x, int y){
        try {
            getBoard()[x][y] = true;
        } catch (IndexOutOfBoundsException e){}
    }

    @Override
    public void turnToDead(int x, int y){
        try {
            getBoard()[x][y] = false;
        } catch (IndexOutOfBoundsException e){}
    }

    @Override
    public boolean isAlive(int x, int y){
        try{
            return getBoard()[x][y];
        } catch (IndexOutOfBoundsException e){
            return false;
        }
    }

    @Override
    public void initiateRandomCells(double v) {
        Random random = new Random();

        boolean[][] board = getBoard();

        for (int y = 0; y < getHeight(); y++){
            for (int x = 0; x < getWidth(); x++){

                if (random.nextDouble() <= v){
                    board[x][y] = true;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int i, int i1) {
        return 0;
    }

    @Override
    public void manageCell(int i, int i1, int i2) {

    }
}
