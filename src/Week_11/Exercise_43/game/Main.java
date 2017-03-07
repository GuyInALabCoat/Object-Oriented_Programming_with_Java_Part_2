package Week_11.Exercise_43.game;

import gameoflife.Simulator;

public class Main {

    public static void main(String[] args) {
        PersonalBoard board = new PersonalBoard(200, 200);

        board.initiateRandomCells(0.7);

        Simulator simulator = new Simulator(board);
        simulator.simulate();

        /*GameOfLifeTester tester = new GameOfLifeTester(board);
        tester.play();*/
    }


}
