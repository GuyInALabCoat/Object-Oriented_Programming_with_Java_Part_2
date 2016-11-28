package com.company;

/**
 * Object-Oriented Programming with Java Part 2 : 2016-11-27
 */

public class Book implements ToBeStored{
    private String writer;
    private String name;
    private double weight;

    public Book(String writer, String name, double weight){
        this.writer = writer;
        this.name = name;
        this.weight = weight;
    }

    public double weight(){
        return this.weight;
    }

    public String getWriter(){
        return this.writer;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.getWriter() + ": " + this.getName();
    }

}
