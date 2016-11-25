package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Dictionary {
    private HashMap<String, String> dictionary;

    public Dictionary(){
        dictionary = new HashMap<String, String>();
    }

    public String translate(String word){
        return this.dictionary.get(word);
    }

    public void add(String word, String translation){
        dictionary.put(word, translation);
    }

    public int amountOfWords(){
        return this.dictionary.size();
    }

    public ArrayList<String> translationList(){
        ArrayList<String> keyWordPairs = new ArrayList<>();
        for (String key : this.dictionary.keySet()){
            keyWordPairs.add(key + " = " + dictionary.get(key));
        }

        return keyWordPairs;
    }

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        dictionary.add("apina", "monkey");
        dictionary.add("banaani", "banana");
        dictionary.add("cembalo", "harpsichord");

        ArrayList<String> translations = dictionary.translationList();
        for(String translation: translations){
            System.out.println(translation);
        }
    }
}
