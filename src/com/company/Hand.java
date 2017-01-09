package com.company;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Exercise 15: Sorting Cards
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-08
 */
public class Hand implements Comparable<Hand>{
    private ArrayList<Card> playerCards;

    public Hand(){
        playerCards = new ArrayList<Card>();
    }

    public void add(Card card){
        playerCards.add(card);
    }

    public void print(){                            // prints the current cards in the hand
        for (Card card : playerCards) {
            System.out.println(card);
        }
    }

    public void sort(){                             // Calls the sort method of the Collections class to sort lists which implement
        Collections.sort(playerCards);              // the Comparable interface. Uses the compareTo method to compare objects.
                                                    // For each card in the List, sorts cards in increasing order based on value
                                                    // as defined in compareTo method in the Card Class
    }

    public int sum(){                               // sums the values of the cards in Hand
        int sum = 0;

        for (Card card: playerCards) {
            sum += card.getValue();
        }

        return sum;
    }

    public int compareTo(Hand hand){                // compares Hands based on the total value of their cards
        return this.sum() - hand.sum();
    }

    public void sortAgainsSuit(){                   // sorts by suit as defined in Comparator class, unless suits are the same, then it sorts by value
        Collections.sort(this.playerCards, new SortAgainstSuitAndValue());
    }

    public static void main(String[] args){

        // 15.4 Comparing Hands

        Hand hand1 = new Hand();

        hand1.add( new Card(2, Card.SPADES));
        hand1.add( new Card(14, Card.CLUBS));
        hand1.add( new Card(12, Card.HEARTS));
        hand1.add( new Card(2, Card.CLUBS));

        Hand hand2 = new Hand();

        hand2.add( new Card(11, Card.DIAMONDS));
        hand2.add( new Card(11, Card.CLUBS));
        hand2.add( new Card(11, Card.HEARTS));

        int comparison = hand1.compareTo(hand2);

        if (comparison < 0){
            System.out.println("the most valuable hand contains the cards");
            hand2.print();
        } else if (comparison > 0){
            System.out.println("the most valuable hand contains the cards");
            hand1.print();
        } else {
            System.out.println("the hands are equally valuable");
        }

        System.out.println();

        // 15.5 Sorting the Cards Against Different Criteria

        ArrayList<Card> cards = new ArrayList<Card>();

        cards.add(new Card(3, Card.CLUBS));
        cards.add(new Card(2, Card.DIAMONDS));
        cards.add(new Card(14, Card.CLUBS));
        cards.add(new Card(12, Card.HEARTS));
        cards.add(new Card(2, Card.CLUBS));

        Collections.sort(cards, new SortAgainstSuitAndValue());

        for (Card c : cards) {
            System.out.println(c);
        }

        System.out.println();

        // 15.6 Sort Against Suit

        Hand hand = new Hand();

        hand.add(new Card(12, Card.HEARTS));
        hand.add(new Card(4, Card.CLUBS));
        hand.add(new Card(2, Card.DIAMONDS));
        hand.add(new Card(14, Card.CLUBS));
        hand.add(new Card(7, Card.HEARTS));
        hand.add(new Card(2, Card.CLUBS));

        hand.sortAgainsSuit();

        hand.print();
    }
}
