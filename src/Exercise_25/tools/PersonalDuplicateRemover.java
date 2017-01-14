package Exercise_25.tools;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Exercise 25: Duplicate Remover
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public class PersonalDuplicateRemover implements DuplicateRemover{
    private List<String> listOfStrings;
    private int numberOfDuplicates;


    public PersonalDuplicateRemover(){
        listOfStrings = new ArrayList<String>();
        numberOfDuplicates = 0;
    }

    @Override
    public void add(String characterString){
        if (listOfStrings.contains(characterString)){
            this.numberOfDuplicates++;
        }

        listOfStrings.add(characterString);
    }

    @Override
    public int getNumberOfDetectedDuplicates(){
        return this.numberOfDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings(){
        Set<String> setOfUniqueStrings = new HashSet<>();

        setOfUniqueStrings.addAll(this.listOfStrings);

        return setOfUniqueStrings;
    }

    @Override
    public void empty() {
        this.listOfStrings.clear();
        this.numberOfDuplicates = 0;
    }

    public static void main(String[] args){
        DuplicateRemover remover = new PersonalDuplicateRemover();
        remover.add("first");
        remover.add("second");
        remover.add("first");

        System.out.println("Current number of duplicates: " + remover.getNumberOfDetectedDuplicates());

        remover.add("last");
        remover.add("last");
        remover.add("new");

        System.out.println("Current number of duplicates: " + remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " + remover.getUniqueCharacterStrings());

        remover.empty();

        System.out.println("Current number of duplicates: " + remover.getNumberOfDetectedDuplicates());

        System.out.println("Unique characterStrings: " + remover.getUniqueCharacterStrings());
    }
}
