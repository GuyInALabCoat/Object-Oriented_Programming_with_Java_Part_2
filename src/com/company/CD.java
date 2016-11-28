package com.company;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-27
 */

public class CD implements ToBeStored{
    private double weight;
    private String artist;
    private String title;
    private int publishing_year;

    public CD(String artist, String title, int publishing_year){
        this.weight = 0.1;
        this.artist = artist;
        this.title = title;
        this.publishing_year = publishing_year;
    }

    public double weight(){
        return this.weight;
    }

    public String getArtist(){
        return this.artist;
    }

    public String getTitle(){
        return this.title;
    }

    public int getPublishing_year(){
        return this.publishing_year;
    }

    public String toString(){
        return this.getArtist() + ": " + this.getTitle() + " (" + this.getPublishing_year() + ") ";
    }
}
