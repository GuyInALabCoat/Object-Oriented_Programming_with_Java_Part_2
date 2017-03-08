package Week_12.Exercise_46.reference.domain;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public class Person {
    private String name;

    public Person(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return getName() != null ? getName().equals(person.getName()) : person.getName() == null;

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getName();
    }
}
