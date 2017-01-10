package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Exercise 16: Ski Jumping
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-09
 */

public class SkiJumping {
    private ArrayList<Jumper> jumpers;
    private Scanner scanner;

    public SkiJumping(){
        jumpers = new ArrayList<Jumper>();
        scanner = new Scanner(System.in);
    }

    public void compete(){
        System.out.println("Kumpula ski jumping week\n");

        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while(true){
            System.out.print("  Participant name: ");

            String input = scanner.nextLine();

            if (input.equals("")){                                  // add participants until user enters an empty string
                break;
            } else {
                jumpers.add(new Jumper(input));
            }
        }

        System.out.println("\nThe tournament begins!");
        int round = 0;
        Judges judges = new Judges();

        while(true){
            System.out.print("\nWrite \"jump\" to jump; otherwise you quit: ");

            if(scanner.nextLine().equals("jump")){

                round++;

                System.out.println("\nRound " + round + "\n");

                Collections.sort(jumpers);                          // sort jumpers according to increasing total scores

                System.out.println("Jumping order:");

                for (Jumper jumper : jumpers) {
                    System.out.println("  " + (jumpers.indexOf(jumper) + 1) + ". " + jumper);
                }

                System.out.println("\nResults of round " + round);

                for (Jumper jumper : jumpers) {
                    System.out.println("  " + jumper.getName());

                    int length = jumper.jump();
                    System.out.println("    length: " + length);    // length of jump

                    int[] judgeScores = judges.generateScores();    // scores of five judges in an array
                    jumper.addToScore(judgeScores[1] + judgeScores[2] + judgeScores[3] + length);   // score is determined to be the sum of the length plus the middle three judges' scores
                    System.out.println("    judge votes: " + Arrays.toString(judgeScores));
                }

            } else {
                break;
            }
        }

        System.out.println("\nThanks!\n");

        Collections.sort(jumpers);
        Collections.reverse(jumpers);

        System.out.println("Tournament results:");
        System.out.println("Position    Name");
        for (Jumper jumper: jumpers) {
            System.out.println((jumpers.indexOf(jumper) + 1) + "           " + jumper);
            System.out.print("            jump lengths: ");
            for (int length: jumper.jumpList()) {
                System.out.print(length + "m, ");
            }

            System.out.println();
        }

    }


    public static void main(String[] args){
        SkiJumping skijumping = new SkiJumping();

        skijumping.compete();
    }

}
