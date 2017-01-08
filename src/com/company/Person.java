package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 13: Rich First, Poor Last
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-07
 */
public class Person implements Comparable<Person> {
    private String name;
    private int salery;

    public Person(String name, int salery){
        this.name = name;
        this.salery = salery;
    }

    public String getName(){
        return this.name;
    }

    public int getSalery(){
        return this.salery;
    }

    public String toString(){
        return this.getName() + " (" + this.getSalery() + ")";
    }

    @Override
    public int compareTo(Person person){                // compare persons of type Person by their salary
        return person.getSalery() - this.getSalery();   // returns -1 if the parameter makes less than this, 0 if equal, and 1 if greater
    }                                                   // Used by Collections.sort to sort objects in List

    public static void main(String[] args){
        List<Person> personList = new ArrayList<Person>();

        personList.add(new Person("Bob", 20000));
        personList.add(new Person("Tom", 50000));
        personList.add(new Person("James", 100000));

        System.out.println(personList);
        Collections.sort(personList);
        System.out.println(personList);
    }
}
