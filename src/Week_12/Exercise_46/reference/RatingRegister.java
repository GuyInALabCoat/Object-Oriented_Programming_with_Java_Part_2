package Week_12.Exercise_46.reference;

import Week_12.Exercise_46.reference.domain.Film;
import Week_12.Exercise_46.reference.domain.Rating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

public class RatingRegister {
    private Map<Film, List<Rating>> filmListMap;

    public RatingRegister(){
        this.filmListMap = new HashMap<>();
    }

    public void addRating(Film film, Rating rating){

        // when creating a new entry in a map, an empty list must be mapped to it first.
        if (!this.filmListMap.containsKey(film)){
            this.filmListMap.put(film, new ArrayList<Rating>());
            this.filmListMap.get(film).add(rating);
        } else {
            this.filmListMap.get(film).add(rating);
        }
    }

    public List<Rating> getRating(Film film) {
        return this.filmListMap.get(film);
    }

    public Map<Film, List<Rating>> filmRatings(){
        return this.filmListMap;
    }

    public static void main(String[] args){

        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");

        RatingRegister reg = new RatingRegister();
        reg.addRating(eraserhead, Rating.BAD);
        reg.addRating(eraserhead, Rating.BAD);
        reg.addRating(eraserhead, Rating.GOOD);

        reg.addRating(theBridgesOfMadisonCounty, Rating.GOOD);
        reg.addRating(theBridgesOfMadisonCounty, Rating.FINE);

        System.out.println("All ratings: " + reg.filmRatings());
        System.out.println("Ratings for Eraserhead: " + reg.getRating(eraserhead));
    }
}
