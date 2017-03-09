package Week_12.Exercise_46.reference.comparator;

import Week_12.Exercise_46.reference.RatingRegister;
import Week_12.Exercise_46.reference.domain.Film;
import Week_12.Exercise_46.reference.domain.Person;
import Week_12.Exercise_46.reference.domain.Rating;

import java.util.*;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-09
 */

public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> filmRatings;

    public FilmComparator(Map<Film, List<Rating>> ratings){
        this.filmRatings = ratings;
    }

    @Override
    public int compare(Film film1, Film film2) {

        double film1Average = calculateAverage(this.filmRatings.get(film1));
        double film2Average = calculateAverage(this.filmRatings.get(film2));

        return (int) (film2Average - film1Average);
    }

    private double calculateAverage(List<Rating> ratings){

        double average = 0.0;

        for (Rating rating : ratings) {
            average += rating.getValue();
        }

        return average / ratings.size();
    }

    public static void main(String[] args){

        RatingRegister ratings = new RatingRegister();

        Film goneWithTheWind = new Film("Gone with the Wind");
        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");

        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");
        Person mikke = new Person("Mikke");

        ratings.addRating(matti, goneWithTheWind, Rating.BAD);
        ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
        ratings.addRating(matti, eraserhead, Rating.FINE);

        ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
        ratings.addRating(pekka, theBridgesOfMadisonCounty, Rating.BAD);
        ratings.addRating(pekka, eraserhead, Rating.MEDIOCRE);

        ratings.addRating(mikke, eraserhead, Rating.BAD);

        Map<Film, List<Rating>> filmRatings = ratings.filmRatings();

        List<Film> films = Arrays.asList(goneWithTheWind, theBridgesOfMadisonCounty, eraserhead);
        System.out.println("The films before sorting: " + films);

        Collections.sort(films, new FilmComparator(filmRatings));
        System.out.println("The films after sorting: " + films);
    }
}
