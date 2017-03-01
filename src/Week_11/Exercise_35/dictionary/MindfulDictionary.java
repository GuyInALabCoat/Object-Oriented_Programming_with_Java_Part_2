package Week_11.Exercise_35.dictionary;

import java.util.HashMap;
import java.util.Map;

/**
 * Exercise 35: Two-Direction Dictionary
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-28
 */

//
public class MindfulDictionary {
    private Map<String, String> dictionary;

    public MindfulDictionary(){                     // create empty dictionary HashMap
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

    public static void main(String[] args){
        MindfulDictionary dict = new MindfulDictionary();

        dict.add("apina", "monkey");
        dict.add("banaani", "banana");
        dict.add("apina", "apfe");

        System.out.println(dict.translate("apina"));
        System.out.println(dict.translate("monkey"));
        System.out.println(dict.translate("programming"));
        System.out.println(dict.translate("banana"));
    }
}
