package com.company;

import java.util.Map;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-28
 */

public class Purchase {
    private String product;
    private int amount;
    private int unitPrice;

    public Purchase(String product, int amount, int unitPrice){
        this.product = product;
        this.amount = amount;
        this.unitPrice = unitPrice;
    }

    public int price(){
        return amount * unitPrice;
    }

    public void increaseAmount(){
        this.amount += 1;
    }

    public String toString(){
        return this.product + ": " + this.amount;
    }

    public static void main(String[] args){
        Purchase purchase = new Purchase("milk", 4, 2);
        System.out.println( "the total price of a purchase containing four milks is " + purchase.price());
        System.out.println(purchase);
        purchase.increaseAmount();
        System.out.println(purchase);
    }
}
