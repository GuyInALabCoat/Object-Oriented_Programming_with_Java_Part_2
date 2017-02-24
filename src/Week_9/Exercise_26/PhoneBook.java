package Week_9.Exercise_26;

import java.util.*;

/**
 * Exercise 26: Phone Search
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-14
 */

public class PhoneBook {
    private Map<String, Set<String>> phoneNumbers;              // Store phone numbers as sets of Strings which are indexed by a String name

    public PhoneBook() {
        phoneNumbers = new HashMap<String, Set<String>>();
    }

    public void addNumber(String name, String number) {
        this.initialize(this.phoneNumbers, name);               // attach an empty HashSet to new index entry

        this.phoneNumbers.get(name).add(number);                // first get the set associated with the key, then add the number to the set
    }

    public void searchForNumber(String name) {
        if (this.phoneNumbers.containsKey(name)) {              // if the given name is a member of the keySet, print the set of numbers associated with the number
            printPhoneEntries(this.phoneNumbers.get(name));
        } else {
            System.out.println("  phone number not found");
        }
    }

    public void searchForPerson(String number) {
        boolean found = false;

        for (String name : this.phoneNumbers.keySet()) {            // loop through all of the keys in the HashMap
            if (this.phoneNumbers.get(name).contains(number)) {     // for each key, if the associated Set contains the number
                System.out.println("  " + name);                    // print the name of the key (name of the person)
                found = true;                                       // mark that a key has been found
            }
        }
        if (!found){
            System.out.println("  not found");
        }
    }

    public void deletePhoneNumbers(String name) {
        this.phoneNumbers.remove(name);
    }

    public Set<String> findKeywords(String keyword) {
        Set<String> matches = new HashSet<String>();

        for (String name : this.phoneNumbers.keySet()) {            // loop through all of the keys in the HashMap
            if (name.contains(keyword)) {                           // if the key contains the keyword
                matches.add(name);                                  // add the key to the set containing all keys
                }
            }
        return matches;
    }


    // when creating a new entry in a map, an empty set must be mapped to it first, luckily both of our maps have the same key, value types
    public void initialize(Map<String, Set<String>> map, String name) {
        if (!map.containsKey(name)) {
            map.put(name, new HashSet<String>());
        }
    }

    public void printPhoneEntries(Set<String> numbers) {            // receives a set of Strings and loops through all strings in the set
        System.out.println("  phone numbers:");

        for (String number : numbers) {
            System.out.println("   " + number);
        }
    }
}
