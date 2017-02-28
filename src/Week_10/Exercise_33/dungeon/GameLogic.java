package Week_10.Exercise_33.dungeon;

import java.util.HashMap;
import java.util.Random;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-26
 */

// main logic of the game as can be determined from the title
class GameLogic {
    private Player player;                                          // the game has a player,
    private Map dungeonMap;                                         // a map
    private HashMap<Vampire, Position> vampireHashMap;              // a HashMap of the vampires and their positions
    private Random random;
    private boolean vampiresMove;                                   // determines if vampires can move or not

   GameLogic(int length, int height, int vampires, int moves, boolean vampiresMove){        // Constructor receives as arguments, a map length, height, the number of vampires in the map, the number of available player moves, and a boolean to determine if vampires can move

       player = new Player(moves);                                  // creates a player with n number of available moves

       this.dungeonMap = new Map(length, height, player);           // creates a map with the given length, height and one player

       vampireHashMap = dungeonMap.addVampires(vampires, length, height);   // add n vampires to the map and get the HashMap with their positions

       random = new Random();

       this.vampiresMove = vampiresMove;
   }

   void printUpdate(){                                              // at the start of each move,

       System.out.println(player.getLampBattery() + "\n");          // print the number of available moves

       System.out.println(player);                                  // print the symbol of the player as well as its current location

       this.vampireHashMap.keySet().forEach(System.out::println);   // print out each of the vampires as well as their current locations

       System.out.println("");

       dungeonMap.printMap();                                       // print out the current map with relevant symbols
   }

   // method to move a player given movement vector
   void movePlayer(int x, int y){                       // it takes two integers that represent the change in an x or y direction

        try {

            validPlayerMove(this.player, x, y);         // call method to move player only if it is a valid move

            if (this.vampiresMove) { moveVampires(); }  // if boolean is set to true, for each player move, the vampires could also move one step

        } catch (IllegalStateException e){              // if no more moves available, throw this exception to end the game
            throw new IllegalStateException();
        }
   }

   // moves the player only if the given move is valid
   private void validPlayerMove(Player player, int x, int y){
        Position position = player.returnCurrentPosition();
        int xpos = position.getXPos();                          // get the player's current position
        int ypos = position.getYPos();

        if (x != 0 && (x + xpos) >= 0 && (x + xpos) <= this.dungeonMap.getLength() ||           // if the move in either direction is not 0, and the change is not less than the minimum value of the map and not more than the maximum value of the map
                y != 0 && (y + ypos) >= 0 && (y + ypos) <= this.dungeonMap.getHeight()){

            this.dungeonMap.map[xpos][ypos] = null;                                             // On the map, set the player's current position to empty
            this.dungeonMap.map[xpos + x][ypos + y] = player;                                   // add the player at the new position (overwrites the entry even if a vampire is there)
            player.move(x, y);                                                                  // update the position for the player itself

            if (this.vampireHashMap.containsKey(new Vampire(xpos + x, ypos + y))){              // if the player at the new position corresponds to a vampire that used to be there,
                this.vampireHashMap.remove(new Vampire(xpos + x, ypos + y));                    // remove the vampire from the HashMap
            }
        }
   }

   // method to move each of the vampires one or no spaces in either direction
   private void moveVampires(){

       HashMap<Vampire, Position> tempHashMap = new HashMap<>();            // create a new HashMap to hold the changes vampire positions

       for (Vampire vampire : this.vampireHashMap.keySet()) {

            int x = 0;                                                      // set the xy change to 0
            int y = 0;

            if(this.random.nextBoolean()){                                  // choose to move either along the x direction or y direction
                x = this.random.nextInt(3) - 1;                             // get a value between -1 and 1 for x
            } else {
                y = this.random.nextInt(3) - 1;                             // get a value between -1 and 1 for y
            }

            validVampireMove(vampire, x, y, tempHashMap);                   // move the vampire along the coordinates only if it is valid

       }

       this.vampireHashMap = tempHashMap;                                   // substitute the current vampire HashMap for the modified HashMap
   }

   // moves the given vampire along the x or y direction only if it is a valid move
   private void validVampireMove(Vampire vampire, int x , int y, HashMap<Vampire, Position> tempHashMap){

        Position position = vampire.returnCurrentPosition();                // get the current vampire position
        int xpos = position.getXPos();
        int ypos = position.getYPos();
        int deltaX = xpos + x;                                              // get the new position with the addition of either x of y
        int deltaY = ypos + y;

        if (x != 0 && (deltaX) >= 0 && (deltaX <= this.dungeonMap.getLength()) ||   // similar logic the the player above, ie, move cannot be 0 and go outside the map
                y != 0 && (deltaY) >= 0 && (deltaY <= this.dungeonMap.getHeight())){

            if (this.dungeonMap.map[deltaX][deltaY] == null){               // if the new position is empty

                this.dungeonMap.map[xpos][ypos] = null;                     // set the current position of the vampire on the map to empty
                this.dungeonMap.map[deltaX][deltaY] = vampire;              // move the vampire to the new position in the map

                vampire.move(x, y);                                         // the position for the vampire itself

                tempHashMap.put(vampire, vampire.returnCurrentPosition());  // add the changed vampire to the temporary HashMap

            } else {                                                        // if the map position is not empty, change nothing and add the vampire as is to the temp HashMap
                tempHashMap.put(vampire, vampire.returnCurrentPosition());
            }
        } else {                                                            // if the move moves outside of the map, change nothing and add the vampire as is to the temp HashMap
            tempHashMap.put(vampire, vampire.returnCurrentPosition());
        }
   }

   int getVampireHashMapSize(){                                             // get the number of vampires
       return this.vampireHashMap.size();
   }

}
