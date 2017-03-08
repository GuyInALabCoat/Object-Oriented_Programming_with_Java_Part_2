package Week_12.Exercise_45.personnel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Exercise 45: Enum and Iterator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public class Employees {
    private List<Person> personnelList;

    public Employees(){
        this.personnelList = new ArrayList<>();
    }

    public void add(Person person){
        this.personnelList.add(person);
    }

    public void add(List<Person> persons){
        this.personnelList.addAll(persons);
    }

    public void print(){
        Iterator<Person> iterator = this.personnelList.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void print(Education education){
        Iterator<Person> iterator = this.personnelList.iterator();

        while(iterator.hasNext()){

            Person person = iterator.next();

            if (person.getEducation().equals(education)){
                System.out.println(person);
            }
        }
    }

    public void fire(Education education){
        Iterator<Person> iterator = this.personnelList.iterator();

        while(iterator.hasNext()){
            if(iterator.next().getEducation().equals(education)){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args){
        Employees university = new Employees();
        university.add(new Person("Matti", Education.D));
        university.add(new Person("Pekka", Education.GRAD));
        university.add(new Person("Arto", Education.D));

        university.print();

        university.fire(Education.GRAD);

        System.out.println("==");

        university.print();
    }
}
