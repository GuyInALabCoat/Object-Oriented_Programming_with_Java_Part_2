package com.company;

import java.util.Comparator;

/**
 * Exercise 15: Sorting Cards
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-08
 */
public class SortAgainstSuitAndValue implements Comparator<Card> {

    // Comparator class which sorts cards by suit first and then by value.
    public int compare(Card card1, Card card2){                 // works the same as a compareTo method thought for suits
        if (card1.getSuit() != card2.getSuit()){                // Sorts spades first, then diamonds, hearts, and finally clubs.
            return card1.getSuit() - card2.getSuit();
        } else {
            return card1.getValue() - card2.getValue();
        }
    }
}
