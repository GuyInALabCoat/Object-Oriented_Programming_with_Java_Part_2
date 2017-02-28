package Week_10.Exercise_33.dungeon;

import java.util.*;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */


// The map object implements the two dimensional dungeon map
class Map {
    public Movable[][] map = new Movable[10][10];   // and a 2-D array with the default size of a 10 x 10 grid
    private Random random;

    Map(int length, int height, Player player){     // Constructor for the dungeon map, it receives as parameters a length, a height and a player object

        map = new Movable[length][height];          // define the dimensions of the dungeon map

        this.random = new Random();                 // set a new random number generator to be used later

        addPlayer(player);                          // add the player to the map

    }

    private void addPlayer(Player player){          // add the player to position 0,0 of the map array
        this.map[player.returnCurrentPosition().getXPos()][player.returnCurrentPosition().getYPos()] = player;
    }

    // method to add n number of vampires to the map at random locations so long as the location is empty
    HashMap<Vampire, Position> addVampires(int vampires, int length, int height){           // it takes as parameters the number of vampires to add, as well as the length and height of the map

        HashMap<Vampire, Position> vampireHashMap = new HashMap<>();                        // it returns a HashMap of all of the positions of each of the added vampires.

        for (int i = 0; i < vampires; i++){         // add the specified number of vampires to the list

            boolean added = false;                  // set boolean to act as a switch to determine when a vampire has been added
            while(!added) {

                int xPosition = this.random.nextInt(length);        // get a random x and y position
                int yPosition = this.random.nextInt(height);

                if (this.map[xPosition][yPosition] == null){        // if the generated position in the array is empty

                    Vampire temp = new Vampire(xPosition, yPosition);   // create a vampire with those coordinates

                    this.map[xPosition][yPosition] = temp;              // add the vampire to the map at those coordinates

                    vampireHashMap.put(temp, temp.returnCurrentPosition());     // add the vampire and its location to the HashMap

                    added = true;                                       // set the switch to true, else the loop would repeat until an available location was found.

                }
            }
        }

        return vampireHashMap;
    }

    int getLength(){                            // return the length of the map
        return this.map.length - 1;
    }

    int getHeight(){                            // return the height of the map
        return this.map[0].length - 1;
    }

    // print out the map with '@' representing the player, 'v' representing the vampires and '.' representing empty spaces
    void printMap(){

        for(int i = 0; i < this.map[0].length; i++){
            for (int j = 0; j < this.map.length; j++){


                if (this.map[j][i] == null) {
                    System.out.print(".");
                } else if (this.map[j][i].getClass() == Vampire.class){
                    System.out.print('v');
                } else if (this.map[j][i].getClass() == Player.class){
                    System.out.print("@");
                }
            }
            System.out.println("");                     // move to a new line
        }

        System.out.println("");                         // print a line after the map
    }
}
