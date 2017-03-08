package Week_12.Exercise_46.reference.domain;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public class Film {
    private String name;

    public Film(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    @Override
    public String toString(){
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Film film = (Film) o;

        return getName() != null ? getName().equals(film.getName()) : film.getName() == null;

    }

    @Override
    public int hashCode() {
        return getName() != null ? getName().hashCode() : 0;
    }

    public static void main(String[] args){
        Rating given = Rating.GOOD;
        System.out.println("Rating " + given + ", value " + given.getValue());
        given = Rating.NEUTRAL;
        System.out.println("Rating " + given + ", value " + given.getValue());
    }
}
