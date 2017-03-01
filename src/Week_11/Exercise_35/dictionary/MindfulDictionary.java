package Week_11.Exercise_35.dictionary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Exercise 35: Two-Direction Dictionary
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-28
 */

//
public class MindfulDictionary {
    private Map<String, String> dictionary;
    private File fileToRead;

    public MindfulDictionary(){                     // create empty dictionary HashMap
        dictionary = new HashMap<String, String>();
    }

    public MindfulDictionary(String file){
        fileToRead = new File(file);

        dictionary = new HashMap<String, String>();
    }

    // method adds a word to the dictionary. Each word has only one translation. If the same word is added twice, nothing happens
    public void add(String word, String translation){

        if (!this.dictionary.containsKey(word)){        // if the dictionary does not contain the word, add the word along with its translation
            this.dictionary.put(word, translation);
        }
    }

    // Returns the word translation, or if the word is not found, it returns null
    public String translate(String word){

        for (Map.Entry<String, String> entry : this.dictionary.entrySet()){     // iterate over all the entries in the HashMap

            if (entry.getKey().equals(word)){               // if the word is in the key set, return its value
                return entry.getValue();

            } else if (entry.getValue().equals(word)){      // vice versa for the value
                return entry.getKey();

            }
        }

        return null;
    }

    // Removes a word from the dictionary given either the word or its translation
    public void remove(String word){

        Iterator<Map.Entry<String, String>> iterator = this.dictionary.entrySet().iterator();   // creates an iterator instance to iterate over the HashMap entries

        while(iterator.hasNext()) {

            Map.Entry<String, String> entry = iterator.next();  // get the next HashMap entry
            if (entry.getKey().equals(word)) {                  // if the word matches the key remove the word from the dictionary
                iterator.remove();

            } else if (entry.getValue().equals(word)) {         // if the word matches the translation remove the word from the dictionary
                iterator.remove();
            }
        }
    }

    // loads a file, whose name was given to the constructor. If opening or reading the file doesn't work it returns false. Else it returns true
    public boolean load(){

        try {

            Scanner fileReader = new Scanner(this.fileToRead);

            while (fileReader.hasNextLine()){
                String line = fileReader.nextLine();
                String[] parts = line.split(":");               // each line is split at :

                this.add(parts[0], parts[1]);                   // add the word before the : and the translation after to the dictionary
            }

        } catch (FileNotFoundException e){
            return false;
        }

        return true;
    }



    public static void main(String[] args){
        /*MindfulDictionary dict = new MindfulDictionary();

        // Exercise 35.1 Forgetful Basic Functionality
        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("apina", "apfe");

        System.out.println(dict.translate("apina"));
        System.out.println(dict.translate("monkey"));
        System.out.println(dict.translate("programming"));
        System.out.println(dict.translate("banana"));*/

        /*// Exercise 35.2 Removing Words
        MindfulDictionary dict = new MindfulDictionary();
        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("ohjelmointi", "programming");
        dict.remove("apina");
        dict.remove("banana");

        System.out.println(dict.translate("apina"));
        System.out.println(dict.translate("monkey"));
        System.out.println(dict.translate("banana"));
        System.out.println(dict.translate("bananni"));
        System.out.println(dict.translate("ohjelmointi"));*/

        // Exercise 35.3 Loading A File
        MindfulDictionary dict = new MindfulDictionary("src/Week_11/Exercise_35/dictionary/words");
        dict.load();

        System.out.println(dict.translate("apina"));
        System.out.println(dict.translate("ohjelmointi"));
        System.out.println(dict.translate("alla oleva"));
    }
}