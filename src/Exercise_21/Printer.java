package Exercise_21;

import java.io.File;
import java.util.Scanner;

/**
 * Exercise 21: Printer
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public class Printer {
    private File f;
    private Scanner reader;

    public Printer(String fileName) throws Exception{
        f = new File(fileName);
    }

    public void printLinesWhichContain(String word){

        try {                                                   // As a Scanner object is unable to cycle through the same file multiple times using .nextLine()
            reader = new Scanner(f);                            // a new instance of a Scanner object must be created every time the file is read.
        } catch (Exception e){
            System.out.println("We couldn't read the file. Error: " + e.getMessage());
            return;
        }

        while (this.reader.hasNextLine()){

            String line = reader.nextLine();

            if (line.contains(word) || word.isEmpty()){         // print line if line contains String or constructor was passed an empty String
                System.out.println(line);
            }
        }

        reader.close();
    }

    public static void main(String[] args){
        Scanner finder = new Scanner(System.in);

        System.out.print("Enter pathname to file you would like to read: ");

        String pathName = finder.nextLine();

        Printer printer = null;                             // Must initialize Printer should the try block fail
        try {
            printer = new Printer(pathName);
        } catch (Exception e) {
            e.printStackTrace();
        }

        printer.printLinesWhichContain("file");             // if unable to open file, printer will remain as null, creating a NullPointerException
        System.out.println("------");
        printer.printLinesWhichContain("Frank Zappa");
        System.out.println("------");
        printer.printLinesWhichContain("");
        System.out.println("------");
    }
}
