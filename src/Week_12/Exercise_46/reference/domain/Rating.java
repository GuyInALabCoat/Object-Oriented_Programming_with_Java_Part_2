package Week_12.Exercise_46.reference.domain;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public enum Rating {
    BAD(-5),
    MEDIOCRE(-3),
    NOT_WATCHED(0),
    NEUTRAL(1),
    FINE(3),
    GOOD(5);

    private int rating;

    private Rating(int rating){
        this.rating = rating;
    }

    int getValue(){
        return this.rating;
    }

}
