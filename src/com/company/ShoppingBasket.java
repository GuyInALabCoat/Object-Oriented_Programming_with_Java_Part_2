package com.company;

import java.util.HashMap;
import java.util.Map;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-28
 */

public class ShoppingBasket {
    private Map<String, Purchase> basket;

    public ShoppingBasket(){
        basket = new HashMap<>();
    }

    public void add(String product, int price) {
        if (basket.containsKey(product)) {       // if the basket already contains the product which we add,
            basket.get(product).increaseAmount();   // update the Purchase object by calling increaseAmount()
        } else {
            basket.put(product, new Purchase(product, 1, price));   // else add new Purchase object
        }
    }

    public int price(){
        int total_price = 0;
        for (Purchase purchase: basket.values()) {
            total_price += purchase.price();
        }

        return total_price;
    }

    public void print(){
        for (Purchase purchase : basket.values()){
            System.out.println(purchase);
        }
    }

    public static void main(String[] args){
        ShoppingBasket basket = new ShoppingBasket();
        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("buttermilk", 2);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");

        basket.add("milk", 3);
        basket.print();
        System.out.println("basket price: " + basket.price() + "\n");
    }
}
