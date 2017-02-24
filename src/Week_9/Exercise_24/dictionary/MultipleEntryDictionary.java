package Week_9.Exercise_24.dictionary;

import java.util.Set;

/**
 * Exercise 24: Multiple Entry Dictionary
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-13
 */

public interface MultipleEntryDictionary {
    void add(String word, String translation);
    Set<String> translate(String word);
    void remove(String word);
}
