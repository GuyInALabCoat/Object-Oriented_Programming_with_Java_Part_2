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

    // returns true if the parameter string contains only vowels
    public static boolean allVowels(String string){
        return string.matches("[aeiou]*");
    }

    // returns true if the parameter string conforms with clock time in the from hh:mm:ss
    public static boolean clockTime(String string){
        return string.matches("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]");
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);

        while(true){

            System.out.print("Give a string: ");

            String input = reader.nextLine();

            if (input.equals("")){
                break;
            }else if (clockTime(input)){
                System.out.println("The form is fine.");
            } else {
                System.out.println("The form is wrong");
            }
        }
    }
}
