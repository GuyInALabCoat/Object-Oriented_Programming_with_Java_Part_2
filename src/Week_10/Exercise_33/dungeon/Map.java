package Week_10.Exercise_33.dungeon;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Exercise 33: Dungeon
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Map {
    private Player player;                  // the game map has 1 player
    private java.util.Map<Vampire, int[]> vampires;          // a list of n vampires
    private int[][] map;                    // and a 2-D array of given dimensions.
    private boolean vampiresMove;
    private Random random;

    public Map(int length, int height, int vampires, int moves, boolean vampiresMove){

        map = new int[length][height];      // define the dimensions of the dungeon map

        this.vampires = new HashMap<Vampire, int[]>();

        this.random = new Random();

        this.addVampires(vampires, length, height);

        player = new Player(moves);

        this.vampiresMove = vampiresMove;
    }

    private int[] generateRandomPosition(int length, int height){
        return new int[] {this.random.nextInt(length), this.random.nextInt(height)};
    }

    private void addVampires(int vampires, int length, int height){
        for (int i = 0; i < vampires; i++){         // add the specified number of vampires to the list
            // since each vampire
            boolean added = false;
            while(!added) {
                Vampire temp = new Vampire(this.generateRandomPosition(length, height));

                if (!(this.vampires.containsKey(temp) || temp.equals(new Vampire(new int[] {0,0})))){
                    this.vampires.put(temp, temp.returnCurrentPosition());
                    added = true;
                }
            }
        }
    }

    public void movePlayer(int x, int y){

        try {

            validMove(this.player, x, y);

            if (this.vampiresMove){
                this.moveVampires();
            }

        } catch (IllegalStateException e){
            throw new IllegalStateException();
        }
    }

    private void moveVampires(){
        for (Vampire vampire : this.vampires.keySet()) {

            int x = 0;
            int y = 0;

            if(this.random.nextBoolean()){
                x = this.random.nextInt(3) - 1;
            } else {
                y = this.random.nextInt(3) - 1;
            }

            validMove(vampire, x, y);

        }
    }

    private void validMove(Movable movable, int x, int y){

        int xpos = movable.returnCurrentPosition()[0];
        int ypos = movable.returnCurrentPosition()[1];

        if (x != 0 && (x + xpos) >= 0 && (x + xpos) <= this.map.length){
            if (detectCollisions(movable, x, y)) {
                if (movable.getClass() == Vampire.class){
                    Vampire vampire = (Vampire) movable;
                    this.vampires.put(vampire, new int[] {xpos + x, ypos + y});
                } else {
                    movable.move(x, y);
                }
            }
        }

        if (y != 0 && (y + ypos) >= 0 && (y + ypos) <= this.map[0].length){
            if (detectCollisions(movable, x, y)) {
                if (movable.getClass() == Vampire.class){
                    Vampire vampire = (Vampire) movable;
                    this.vampires.put(vampire, new int[] {xpos + x, ypos + y});
                } else {
                    movable.move(x, y);
                }
            }
        }
    }

    private boolean detectCollisions(Movable movable, int x, int y){

        int deltaX = movable.returnCurrentPosition()[0] + x;
        int deltaY = movable.returnCurrentPosition()[1] + y;

        if (movable.getClass() == Player.class){
            if (this.vampires.keySet().contains(new Vampire(new int[] {deltaX, deltaY}))){
                this.vampires.keySet().remove(new Vampire(new int[] {deltaX, deltaY}));
                return true;
            }
        } else {
            if (this.vampires.keySet().contains(new Vampire(new int[]{deltaX, deltaY}))){
                return false;
            }
        }

        return true;
    }

    public void printMap(){
        int xpos = this.player.returnCurrentPosition()[0];
        int ypos = this.player.returnCurrentPosition()[1];

        for(int i = 0; i < this.map[0].length; i++){
            for (int j = 0; j < this.map.length; j++){

                if (this.vampires.containsKey(new Vampire(new int[] {j, i}))){
                    System.out.print('v');
                } else if (j == xpos && i == ypos){
                    System.out.print(this.player.toString());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }

    public static void main(String[] args){
        Map dungeonMap = new Map(15, 5, 10, 6, true);

        dungeonMap.printMap();

        dungeonMap.movePlayer(0, 1);

        dungeonMap.printMap();

        dungeonMap.movePlayer(1, 0);

        dungeonMap.printMap();

        // TODO: figure out how to get vampires to move and not disappear from the map. Consider deleting Position.java
    }


}
