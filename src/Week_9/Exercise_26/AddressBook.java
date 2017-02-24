package Week_9.Exercise_26;

import java.util.*;

/**
 * Exercise 26: Phone Search
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-14
 */

public class AddressBook {
    private Map<String, Set<String>> addresses;                                 // store addresses as sets of Strings which are indexed by a String

    public AddressBook(){
        addresses = new HashMap<String, Set<String>>();
    }

    public void addAddress(String name, String street, String city){
        this.initialize(this.addresses, name);                                  // initialize a new entry with an empty HashSet

        this.addresses.get(name).add(street + " " + city);                      // add street and city into a single String
    }

    public void searchForAddress(String name){
        if (this.addresses.containsKey(name)){                                  // if the address book contains the key, print all addresses associated with the key
            printAddresses(this.addresses.get(name));
        } else {
            System.out.println("  address unknown");
        }
    }

    public void deleteAddresses(String name){
        this.addresses.remove(name);
    }

    public Set<String> findKeywords(String keyword) {
        Set<String> matches = new HashSet<String>();

        for (String name : this.addresses.keySet()) {                           // loop through all keys in the keySet
            if (name.contains(keyword) || this.keywordMatchesStringSet(this.addresses.get(name), keyword)) {    // if the key contains the keyword or one of the addresses in the associated set
                matches.add(name);                                                                              // contains the keyword, add the key to the set of all matched keys
            }
        }

        return matches;
    }

    public boolean keywordMatchesStringSet(Set<String> addresses, String keyword){          // parse through all strings in the set to see if any String contains the keyword
        for (String address : addresses) {
            if (address.contains(keyword)){
                return true;
            }
        }

        return false;
    }

    public void printAddresses(Set<String> addresses){                                      // print all addresses in the set
        for (String address : addresses) {
            System.out.print("  address: " + address + "\n");
        }
    }

    // when creating a new entry in a map, an empty set must be mapped to it first, luckily both of our maps have the same key, value types
    public void initialize(Map<String, Set<String>> map, String name){
        if (!map.containsKey(name)){
            map.put(name, new HashSet<String>());
        }
    }
}
