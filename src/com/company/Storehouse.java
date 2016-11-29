package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-28
 */

public class Storehouse {
    private Map<String, Integer> catalogue;
    private Map<String, Integer> stock;

    public Storehouse(){
        this.catalogue = new HashMap<String, Integer>();
        this.stock = new HashMap<String, Integer>();
    }

    public void addProduct(String product, int price, int stock){
        this.catalogue.put(product, price);
        this.stock.put(product, stock);
    }

    public int price(String product){
        if (this.catalogue.containsKey(product)){    // if the product exists in the HashMap catalogue
            return catalogue.get(product);       // return the price of the product
        }

        return -99;                             // else return -99 if the product does not exist in the catalogue
    }

    public int stock(String product){
        if (this.stock.containsKey(product)){
            return this.stock.get(product);
        }

        return 0;
    }

    public boolean take(String product){
        if (this.stock.containsKey(product) && (this.stock.get(product) > 0)){  // if the product is listed in the stock, and is available
            this.stock.replace(product, (this.stock.get(product) - 1)); // decrease the stock of the product by 1
            return true;
        }

        return false;
    }

    public Set<String> products(){
        return this.stock.keySet();
    }

    public static void main(String[] args){
        Storehouse store = new Storehouse();
        store.addProduct("milk", 3, 10);
        store.addProduct("coffee", 5, 6);
        store.addProduct("buttermilk", 2, 20);
        store.addProduct("yogurt", 2, 20);

        System.out.println("products:");
        for (String product : store.products()){
            System.out.println(product);
        }

    }
}
