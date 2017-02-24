package Week_10.Exercise_29.people;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 29: Person and their Heirs
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-08
 */

public class Main {

    public static void printDepartment(List<Person> people){
        for (Person person : people) {
            System.out.println(person);
        }
    }

    public static void main(String[] args){
        List<Person> people = new ArrayList<Person>();
        people.add(  new Teacher("Pekka Mikkola", "Korsontie Street 1 03100 Vantaa", 1200) );
        people.add(  new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki") );

        printDepartment(people);

    }
}
