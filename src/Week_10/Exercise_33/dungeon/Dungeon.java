package Week_10.Exercise_33.dungeon;

import java.util.Scanner;

import static java.lang.System.exit;
import static java.lang.System.setOut;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

// Main User Interface, handles user input and passes input onto the logic to change game variables
public class Dungeon {
    private GameLogic logic;            // has a central game logic
    private Scanner scanner;            // has a scanner to read user input

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove){      // game constructor that creates a dungeon map of a certain length and height, creates n vampires, creates a player with m moves, and sets whether vampires are allowed to move

        logic = new GameLogic(length, height, vampires, moves, vampiresMove);                   // creates game objects via logic

        scanner = new Scanner(System.in);                                                       // create scanner to read user input from console
    }

    // run the interface, and pass input to logic
    public void run(){

        while (logic.getVampireHashMapSize() > 0){              // while there exists vampires on the map

            logic.printUpdate();                                // print a game update

            System.out.print("Enter moves on wasd keys: ");

            String input = scanner.nextLine();                  // read user input

            char[] commands = commandString(input);             // convert user input string to a character array

            for (char command : commands) {                     // loop through array and match characters to movements, call logic to move player

                try {

                    switch (command) {

                        case 'w':
                            logic.movePlayer(0, -1);
                            break;
                        case 's':
                            logic.movePlayer(0, 1);
                            break;
                        case 'a':
                            logic.movePlayer(-1, 0);
                            break;
                        case 'd':
                            logic.movePlayer(1, 0);
                            break;
                        default:
                            System.out.println("Unknown command");
                            break;
                    }

                } catch (IllegalStateException e) {             // if the player throws an exception catch it, and execute the end of the game
                    Lose();
                }
            }
        }

        Win();                                                  // else execute the win method
    }

    private char[] commandString(String input){

        return input.toCharArray();

    }

    private void Lose(){
        System.out.println("YOU LOSE");
        exit (1);
    }

    private void Win(){
        System.out.println("YOU WIN");
    }

    public static void main(String[] args){

        Dungeon dungeon = new Dungeon(20, 15, 15, 100, true);       // create a 5 x 5 dungeon map with 2 vampires and 10 available moves, vampires can move

        dungeon.run();
    }
}
