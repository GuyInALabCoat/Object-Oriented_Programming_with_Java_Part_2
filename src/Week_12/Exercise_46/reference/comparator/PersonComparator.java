package Week_12.Exercise_46.reference.comparator;

import Week_12.Exercise_46.reference.domain.Person;

import java.util.*;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-09
 */

public class PersonComparator implements Comparator<Person> {
    private Map<Person, Integer> personIntegerMap;

    public PersonComparator(Map<Person, Integer> peopleIdentities){
        this.personIntegerMap = peopleIdentities;
    }

    // compares people to sort a collection of people from largest to smallest based on their number
    @Override
    public int compare(Person person1, Person person2) {
        return this.personIntegerMap.get(person2) - this.personIntegerMap.get(person1);
    }

    public static void main(String[] args){

        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");
        Person mikke = new Person("Mikke");
        Person thomas = new Person("Thomas");

        Map<Person, Integer> peopleIdentities = new HashMap<Person, Integer>();
        peopleIdentities.put(matti, 42);
        peopleIdentities.put(pekka, 134);
        peopleIdentities.put(mikke, 8);
        peopleIdentities.put(thomas, 82);

        List<Person> ppl = Arrays.asList(matti, pekka, mikke, thomas);
        System.out.println("People before sorting: " + ppl);

        Collections.sort(ppl, new PersonComparator(peopleIdentities));
        System.out.println("People after sorting: " + ppl);
    }
}
