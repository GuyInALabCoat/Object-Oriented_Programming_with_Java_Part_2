package Week_12.Exercise_45.personnel;

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
            if(iterator.next().getEducation().equals(education)){
                System.out.println(iterator.next());
            }
        }
    }
}
