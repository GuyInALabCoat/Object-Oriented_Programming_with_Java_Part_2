package Week_11.Exercise_34;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Exercise 34: File Manager
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-28
 */

public class FileManager {

    public ArrayList<String> read(String file) throws Exception{
        File fileToRead = new File(file);
        Scanner reader = new Scanner(fileToRead);
        ArrayList<String> linesInFile = new ArrayList<>();

        while(reader.hasNextLine()){
            linesInFile.add(reader.nextLine());
        }

        return linesInFile;
    }

    public void save(String file, String text) throws Exception{
        FileWriter writer = new FileWriter(file);
        writer.write(text);
    }

    public void save(String file, ArrayList<String> texts) throws Exception{
        FileWriter writer = new FileWriter(file);

        for (String line : texts) {
            writer.write(line);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException{
        FileManager f = new FileManager();

        try {
            for (String line : f.read("src/Week_11/Exercise_34/testinput1.txt")){
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new FileNotFoundException();
        }
    }
}
