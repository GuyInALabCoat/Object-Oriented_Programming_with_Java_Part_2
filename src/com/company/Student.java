package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Exercise 14: Students Sorted by Name
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-07
 */
public class Student implements Comparable<Student> {
    private String name;

    public Student(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public int compareTo(Student student){                              // Compares student's names to determine alphabetical order (Ignores Case)
        return this.getName().compareToIgnoreCase(student.getName());   // Used by Collections.sort to sort a List
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public static void main(String[] args){
        List<Student> studentList = new ArrayList<Student>();

        studentList.add(new Student("George"));
        studentList.add(new Student("Axel"));
        studentList.add(new Student("David"));
        studentList.add(new Student("James"));

        System.out.println(studentList);
        Collections.sort(studentList);
        System.out.println(studentList);

    }

}
