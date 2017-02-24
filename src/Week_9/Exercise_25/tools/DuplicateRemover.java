package Week_9.Exercise_25.tools;

import java.util.Set;

/**
 * Exercise 25: Duplicate Remover
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public interface DuplicateRemover {
    void add(String characterString);
    int getNumberOfDetectedDuplicates();
    Set<String> getUniqueCharacterStrings();
    void empty();
}
