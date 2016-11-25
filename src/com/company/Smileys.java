package com.company;

public class Smileys {

    private static void printWithSmileys(String characterString){
        int length = characterString.length();

        if (length % 2 == 1){
            length++;
            printLine(length);
            System.out.println(":) " + characterString + "  :)");
            printLine(length);
        } else {
            printLine(length);
            System.out.println(":) " + characterString + " :)");
            printLine(length);
        }


    }

    private static void printLine(int length){

        for (int i = 0; i < length + 1; i++){
            System.out.print(":)");
        }

        System.out.println("");
    }

    public static void main(String[] args){
        printWithSmileys("\\:D/");
        printWithSmileys("87.");
    }

}
