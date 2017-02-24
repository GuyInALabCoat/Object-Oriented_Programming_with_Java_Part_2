package Week_9.Exercise_19.Method_Argument_Validation;

/**
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class Person {
    private String name;
    private int age;

    public Person(String name, int age){
        if (name.isEmpty() || name == null || name.length() > 40){
            throw new IllegalArgumentException("Passed name variable must not be empty, mull or longer than 40 characters");
        }

        if (age < 0 || age > 120){
            throw new IllegalArgumentException("Age must be between 0 and 120 years");
        }
    }

    public static void main(String[] args){
//        Person person1 = new Person("", 5);
//        Person person2 = new Person(null, 10);
//        Person person3 = new Person("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA", 15);
//        Person person4 = new Person("David", -20);
//        Person person5 = new Person("George", 240);
    }
}
