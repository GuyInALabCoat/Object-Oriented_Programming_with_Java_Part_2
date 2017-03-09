package Week_12.Exercise_46.reference;

import Week_12.Exercise_46.reference.comparator.FilmComparator;
import Week_12.Exercise_46.reference.domain.Film;
import Week_12.Exercise_46.reference.domain.Person;
import Week_12.Exercise_46.reference.domain.Rating;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-09
 */

// Recommends a film for a person who has never evaluated any movie
public class Reference {
    private RatingRegister ratings;

    // receives a register with films and their ratings
    public Reference(RatingRegister register){
        this.ratings = register;
    }

    public Film recommendFilm(Person person){

        // get the map of films and their ratings from the register
        Map<Film, List<Rating>> filmRatings = this.ratings.filmRatings();

        // get the list of films in the register
        List<Film> availableFilms = getAvailableFilms();

        // sort the list according to the film comparator (positive - negative)
        Collections.sort(availableFilms, new FilmComparator(filmRatings));

        // return the first entry in the sorted list
        return availableFilms.get(0);
    }

    // return the list of films from the register
    private List<Film> getAvailableFilms(){

        List<Film> films = new ArrayList<>();

        for (Film film : this.ratings.filmRatings().keySet()) {
            films.add(film);
        }

        return films;
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

        Reference ref = new Reference(ratings);
        Film recommended = ref.recommendFilm(mikke);
        System.out.println("The film recommended to Michael is: " + recommended);
    }
}
