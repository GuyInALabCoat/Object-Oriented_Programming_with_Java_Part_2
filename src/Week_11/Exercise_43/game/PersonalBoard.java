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
    public void initiateRandomCells(double probabilityForEachCell) {
        Random random = new Random();

        boolean[][] board = getBoard();

        for (int y = 0; y < getHeight(); y++){
            for (int x = 0; x < getWidth(); x++){

                if (random.nextDouble() <= probabilityForEachCell){
                    board[x][y] = true;
                }
            }
        }
    }

    @Override
    public int getNumberOfLivingNeighbours(int x, int y) {
        int numberLiving = 0;

        for (int j = y - 1; j <= y + 1; j++){
            for (int i = x - 1; i <= x + 1; i++){

                if ((i != x || j != y) && isAlive(i, j)){
                    numberLiving++;
                }
            }
        }

        return numberLiving;
    }

    @Override
    public void manageCell(int x, int y, int livingNeighbours) {
        boolean cellAlive = isAlive(x, y);

        if (cellAlive && livingNeighbours < 2){
            turnToDead(x, y);
        } else if (cellAlive && livingNeighbours <= 3){

        } else if (cellAlive && livingNeighbours > 3){
            turnToDead(x, y);
        } else if (!cellAlive && livingNeighbours == 3){
            turnToLiving(x, y);
        }
    }
}
