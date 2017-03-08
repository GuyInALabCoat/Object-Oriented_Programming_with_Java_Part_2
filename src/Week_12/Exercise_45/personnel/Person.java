package Week_12.Exercise_45.personnel;

/**
 * Exercise 45: Enum and Iterator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public class Person {
    private String name;
    private Education education;

    public Person(String name, Education education){
        this.name = name;
        this.education = education;
    }

    public Education getEducation(){
        return this.education;
    }

    @Override
    public String toString(){
        return this.name + ", " + getEducation();
    }

    public static void main(String[] args){
        Person arto = new Person("Arto", Education.D);
        System.out.println(arto);
    }
}
