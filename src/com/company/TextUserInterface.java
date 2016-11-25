package com.company;

import java.util.Scanner;

public class TextUserInterface {
    private Scanner reader;
    private Dictionary dictionary;

    public TextUserInterface(Scanner reader, Dictionary dictionary){
        this.reader = reader;
        this.dictionary = dictionary;
    }

    public void start(){
        System.out.println("Statement:\n" +
                "\tadd - adds a word pair to the dictionary\n" +
                "\ttranslate - asks a word and prints its translation\n" +
                "\tquit - quit the text user interface\n");


        while (true) {
            System.out.print("Statement: ");
            String input = reader.nextLine();

            if (input.equals("quit")) {
                System.out.println("Cheers!\n");
                break;
            }
            else if (input.equals("add")){
                System.out.print("In Finnish: ");
                String finnish = reader.nextLine();
                System.out.print("Translation: ");
                String english = reader.nextLine();
                dictionary.add(finnish, english);
                System.out.println("");
            }
            else if (input.equals("translate")){
                System.out.print("Give a word: ");
                String word = reader.nextLine();
                System.out.println("Translation: " + dictionary.translate(word));
                System.out.println("");
            }
            else {
                System.out.println("Unknown statement\n");
            }
        }
    }

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Dictionary dict = new Dictionary();

        TextUserInterface ui = new TextUserInterface(reader, dict);
        ui.start();
    }
}
