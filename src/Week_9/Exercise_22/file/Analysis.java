package Week_9.Exercise_22.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Exercise 22: File Analysis
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public class Analysis {
    private File fileToRead;
    private Scanner reader;

    public Analysis(File file){
        fileToRead = file;
    }

    public int lines(){
        int lines = 0;

        try {
            reader = new Scanner(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNextLine()){
            reader.nextLine();
            lines++;
        }

        return lines;
    }

    public int characters(){
        int characters = 0;

        try {
            reader = new Scanner(fileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(reader.hasNextLine()){
            characters += reader.nextLine().length();
            characters++;                                       // to count the number of newline characters which are removed by .nextLine
        }

        return characters;
    }

    public static void main(String[] args){

        File file = new File("src/Week_9/Exercise_22/file/testfile.txt");
        Analysis analysis = new Analysis(file);
        System.out.println("Lines: " + analysis.lines());
        System.out.println("Characters: " + analysis.characters());
    }
}
