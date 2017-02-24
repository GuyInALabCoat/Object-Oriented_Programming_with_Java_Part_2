package Week_9.Exercise_24.dictionary;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Exercise 24: Multiple Entry Dictionary
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary{
    private Map<String, Set<String>> dictionary;


    public PersonalMultipleEntryDictionary(){
        dictionary = new HashMap<String, Set<String>>();
    }

    public void add(String word, String translation){

        // if an entry does not exist in the dictionary, an empty set must first be mapped to the entry
        if (!this.dictionary.containsKey(word)){
            this.dictionary.put(word, new HashSet<String>());
        }

        // add the new translation to the set under the entry
        this.dictionary.get(word).add(translation);
    }

    public Set<String> translate(String word){
        if (this.dictionary.containsKey(word)){         // if the dictionary contains the word, return the set of translations under the entry
            return this.dictionary.get(word);
        } else {                                        // else return a null reference
            return null;
        }
    }

    public void remove(String word){                    // removes a word and all its entries from the dictionary
        this.dictionary.remove(word);
    }

    public static void main(String[] args){
        MultipleEntryDictionary dict = new PersonalMultipleEntryDictionary();
        dict.add("kuusi", "six");
        dict.add("kuusi", "spruce");

        dict.add("pii", "silicon");
        dict.add("pii", "pi");

        System.out.println(dict.translate("kuusi"));
        dict.remove("pii");
        System.out.println(dict.translate("pii"));
    }
}
