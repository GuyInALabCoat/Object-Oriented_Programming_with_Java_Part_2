package Week_12.Exercise_44;

import java.util.Scanner;

/**
 * Exercise 44: Regular Expressions
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-07
 */

public class Main {

    // returns true if the parameter string matches an abbreviation of a week day
    public static boolean isAWeekDay(String string){
        return string.matches("mon|tue|wed|thu|fri|sat|sun");
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        while(true){

            System.out.print("Give a string: ");

            String input = reader.nextLine();

            if (input.equals("")){
                break;
            }else if (isAWeekDay(input)){
                System.out.println("The form is fine.");
            } else {
                System.out.println("The form is wrong");
            }
        }
    }
}
