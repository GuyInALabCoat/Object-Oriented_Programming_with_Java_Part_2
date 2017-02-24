package Week_10.Exercise_29.people;

/**
 * Exercise 29: Person and their Heirs
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-08
 */

public class Person {
    private String name;
    private String address;

    public Person(String name, String address){
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString(){
        return this.name + "\n  " + this.address;
    }

    public static void main(String[] args){
        Person john = new Person("John Smith", "100 South Street London");
        Person adam = new Person("Adam Ledger", "450 Watermill Road Philadelphia");
        System.out.println(john);
        System.out.println(adam);
    }
}
