package Week_9.Exercise_26;

import java.util.*;

/**
 * Exercise 26: Phone Search
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-14
 */

public class PhoneSearch {
    private Scanner reader;
    private PhoneBook phoneBook;
    private AddressBook addressBook;

    public PhoneSearch(){
        reader = new Scanner(System.in);
        phoneBook = new PhoneBook();
        addressBook = new AddressBook();
    }

    public String readNext(){                               // read next line of input
        return this.reader.nextLine();
    }

    public void numberPad(){                                // Handles the user interface at input

        boolean value = true;

        while(value){                                       // set up infinite loop

            String name;                                    // declare variables to whom values will be assigned
            String number;
            String street;
            String city;
            String keyword;

            System.out.print("\ncommand: ");

            String input = this.readNext();

            switch (input) {                                // the user can enter single numbers between 1-7 to pass through the menu and x to quit
                // add a number
                case "1":
                    System.out.print("whose number: ");
                    name = this.readNext();

                    System.out.print("number: ");
                    number = this.readNext();

                    phoneBook.addNumber(name, number);         // pass handling entry input to method
                    break;

                // search for a number
                case "2":
                    System.out.print("whose number: ");
                    name = readNext();

                    phoneBook.searchForNumber(name);            // pass search to method
                    break;

                // search for a person by phone number
                case "3":
                    System.out.print("number: ");
                    number = readNext();

                    phoneBook.searchForPerson(number);
                    break;

                // add an address
                case "4":
                    System.out.print("whose address: ");
                    name = readNext();

                    System.out.print("street: ");
                    street = readNext();

                    System.out.print("city: ");
                    city = readNext();

                    addressBook.addAddress(name, street, city);
                    break;

                // search for personal information
                case "5":
                    System.out.print("whose information: ");
                    name = readNext();

                    this.searchForInformation(name);
                    break;

                // delete personal information
                case "6":
                    System.out.print("whose information: ");
                    name = readNext();

                    this.deleteInformation(name);
                    break;

                // filtered listing
                case "7":
                    System.out.print("keyword (if empty, all listed): ");
                    keyword = readNext();

                    this.keywordSearch(keyword);
                    break;

                // quit
                case "x":
                    value = false;                              // break infinite loop
                    break;


                default:
                    System.out.println("Invalid input! Please enter a valid number or press x to quit.");
                    break;
            }
        }
    }

    public void searchForInformation(String name){
        addressBook.searchForAddress(name);
        phoneBook.searchForNumber(name);
    }

    public void deleteInformation(String name){
        phoneBook.deletePhoneNumbers(name);
        addressBook.deleteAddresses(name);
    }

    public void keywordSearch(String keyword){
        Set<String> matchedSet = new TreeSet<String>(phoneBook.findKeywords(keyword));                  // create a set from the output of the keyword search through the phone book: a set
        matchedSet.addAll(addressBook.findKeywords(keyword));                                           // add to the set all keywords returned from the search through the address book : a set
                                                                                                        // since TreeSet implements SortedSet, all keywords in the set are ordered according to
        if (!matchedSet.isEmpty()){                                                                     // their natural ordering, i.e., alphabetical. So long as the collective set is not empty
            for (String word : matchedSet) {                                                            // print out the matched keyword in the original Maps, and all information associated with the keyword.
                System.out.println("\n " + word);
                this.searchForInformation(word);
            }
        } else {
            System.out.println("  keyword not found");                                                  // print only if the collective set is empty, i.e., when nothing was found.
        }
    }

    public void menu(){                                             // print the user directions
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");

        this.numberPad();
    }

    public static void main(String[] args){
        PhoneSearch phoneSearch = new PhoneSearch();

        phoneSearch.menu();
    }
}
