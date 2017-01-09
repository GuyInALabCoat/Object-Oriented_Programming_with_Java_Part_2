package com.company;

/**
 * Exercise 15: Sorting Cards
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-08
 */
public class Card implements Comparable<Card>{
    public static final int SPADES = 0;                 // Four constants to represent the four card suits as numbers
    public static final int DIAMONDS = 1;
    public static final int HEARTS = 2;
    public static final int CLUBS = 3;

    private final int value;
    private final int suit;

    public Card(int value, int suit){
        this.value = value;
        this.suit = suit;
    }

    public int getValue(){
        return this.value;
    }

    public int getSuit(){
        return this.suit;
    }

    @Override
    public String toString(){                           // returns a String which represents the value and suit of each card
        String value;                                   // Where necessary, it substitutes the int representation of value and suit with a String
        String suit;

        if (this.getValue() <= 10 && this.getValue() >= 2){
            value = Integer.toString(this.getValue());
        } else if (this.getValue() > 10 && this.getValue() <= 14){
            switch(this.getValue()){
                case 11: value = "J";
                    break;
                case 12: value = "Q";
                    break;
                case 13: value = "K";
                    break;
                case 14: value = "A";
                    break;
                default: value = "Invalid value";
                    break;
            }
        } else {
            value = "Invalid value";
        }

        switch(this.getSuit()){
            case 0: suit = "Spades";
                break;
            case 1: suit = "Diamonds";
                break;
            case 2: suit = "Hearts";
                break;
            case 3: suit = "Clubs";
                break;
            default: suit = "Invalid suit";
                break;
        }

        return value + " of " + suit;

    }

    @Override
    public int compareTo(Card card){                        // used by Collections.sort to sort cards by value first and by suit second.
        if (this.getValue() != card.getValue()){            // Spades first, diamonds, hearts, and finally clubs last.
            return this.getValue() - card.getValue();
        } else {
            return this.getSuit() - card.getSuit();
        }
    }

    public static void main(String[] args){

        // 15.1 Comparable Cards

        Card first = new Card(2, Card.DIAMONDS);
        Card second = new Card(14, Card.CLUBS);
        Card third = new Card(12, Card.HEARTS);

        System.out.println(first);
        System.out.println(second);
        System.out.println(third);
    }
}
