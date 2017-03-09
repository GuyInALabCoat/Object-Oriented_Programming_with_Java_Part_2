package Week_12.Exercise_46.reference;

import Week_12.Exercise_46.reference.domain.Film;
import Week_12.Exercise_46.reference.domain.Person;
import Week_12.Exercise_46.reference.domain.Rating;

import java.util.*;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-08
 */

// RatingRegister contains a map of people along with their map of films that they've seen and their ratings for each film
public class RatingRegister {
    private Map<Person, Map<Film, List<Rating>>> personFilmMap;

    public RatingRegister(){
        this.personFilmMap = new HashMap<Person, Map<Film, List<Rating>>>();
    }

    // In cases where people do not provide their name, all of their ratings are stored under the null key and there may be more than one rating per film
    public void addRating(Film film, Rating rating){

        addRating(null, film, rating);  // The addition of films and ratings is done by the overloaded method that accepts a person variable. In the case of anonymous ratings the value of the person parameter is null
    }

    public void addRating(Person person, Film film, Rating rating){

            // if the person does not exist in the current map, add the person, the film that they saw and their rating for it
            if (!this.personFilmMap.containsKey(person)) {
                this.personFilmMap.put(person, new HashMap<Film, List<Rating>>());
                this.personFilmMap.get(person).put(film, new ArrayList<Rating>());
                this.personFilmMap.get(person).get(film).add(rating);

            // if the person exists, but does not have the film in their watched list, add the film and their rating for it
            } else if (!this.personFilmMap.get(person).containsKey(film)) {
                this.personFilmMap.get(person).put(film, new ArrayList<Rating>());
                this.personFilmMap.get(person).get(film).add(rating);

            // else if the person is anonymous, add the rating to the film under the null key
            } else if (person == null){
                this.personFilmMap.get(person).get(film).add(rating);

            // else if the person exists and has the film in their list, but there is no rating for it, add the rating
            } else if (this.personFilmMap.get(person).get(film) == null){
                this.personFilmMap.get(person).get(film).add(rating);
            }

            // else the person exists and they have watched and rated the film, in which case they cannot give a new rating
    }

    // return all the ratings for a given film, both by listed people and anonymous reviewers
    public List<Rating> getRatings(Film film) {
        List<Rating> temp = new ArrayList<Rating>();    // create a temporary list to hold the ratings

        Iterator<Map<Film, List<Rating>>> iterator = this.personFilmMap.values().iterator();    // iterate through each nested HashMaps

        while(iterator.hasNext()){
            Map<Film, List<Rating>> filmListMap = iterator.next();

            if (filmListMap.containsKey(film)){                                                 // if the map contains the film,
                temp.addAll(filmListMap.get(film));                                             // add the list of ratings to the temporary list
            }
        }
        return temp;    // return the temporary list
    }

    // return the rating that a given person gave the specified film
    public Rating getRatings(Person person, Film film){
        return this.personFilmMap.get(person).get(film).get(0);
    }

    // returns a map of films plus their ratings
    public Map<Film, List<Rating>> filmRatings(){
        Map<Film, List<Rating>> temp = new HashMap<Film, List<Rating>>();

        Iterator<Map<Film, List<Rating>>> iterator = this.personFilmMap.values().iterator();    // iterate through the nested HashMaps

        while(iterator.hasNext()){

            Map<Film, List<Rating>> filmListMap = iterator.next();

            for (Film film : filmListMap.keySet()) {                                            // a each film in one of the HashMaps

                if (!temp.containsKey(film)){                           // if the temporary map does not contain that film
                    temp.put(film, new ArrayList<Rating>());            // add the film along with all associated ratings
                    temp.get(film).addAll(filmListMap.get(film));
                } else {
                    temp.get(film).addAll(filmListMap.get(film));       // else add all associated ratings to the entry under the film
                }
            }
        }
        return temp;        // return the temporary map
    }

    // returns a map of a person's personal ratings for each film that they've seen
    public Map<Film, Rating> getPersonalRatings(Person person){

        Map<Film, Rating> tempMap = new HashMap<Film, Rating>();

        Iterator<Map.Entry<Film, List<Rating>>> iterator = this.personFilmMap.get(person).entrySet().iterator();    // iterate through the HashMap associated with a person

        while(iterator.hasNext()){

            Map.Entry<Film, List<Rating>> entry = iterator.next();          // get the next film and list of ratings.

            tempMap.put(entry.getKey(), entry.getValue().get(0));           // since each named person can only rate a film once, their ratings list is of length 1, so add the first entry to the temporary map
        }

        return tempMap;     // return the temporary map

    }

    // returns a list of people who have evaluated the films without all of the anonymous reviewers
    public List<Person> reviewers(){
        List<Person> tempList = new ArrayList<>(this.personFilmMap.keySet());
        tempList.remove(null);
        return tempList;
    }

    public static void main(String[] args){

        // Exercise 46.3 RatingRegister, Part 1

        RatingRegister ratings = new RatingRegister();

        /*Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");
        ratings.addRating(eraserhead, Rating.BAD);
        ratings.addRating(eraserhead, Rating.BAD);
        ratings.addRating(eraserhead, Rating.GOOD);

        ratings.addRating(theBridgesOfMadisonCounty, Rating.GOOD);
        ratings.addRating(theBridgesOfMadisonCounty, Rating.FINE);

        System.out.println("All ratings: " + ratings.filmRatings());
        System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserhead));*/

        // Exercise 46.4 RatingRegister, Part 2

        Film goneWithTheWind = new Film("Gone with the Wind");
        Film eraserhead = new Film("Eraserhead");

        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");

        ratings.addRating(matti, goneWithTheWind, Rating.BAD);
        ratings.addRating(matti, eraserhead, Rating.FINE);

        ratings.addRating(pekka, goneWithTheWind, Rating.GOOD);
        ratings.addRating(pekka, eraserhead, Rating.GOOD);

        System.out.println("Ratings for Eraserhead: " + ratings.getRatings(eraserhead));
        System.out.println("Matti's ratings: " + ratings.getPersonalRatings(matti));
        System.out.println("Reviewers: " + ratings.reviewers());

    }
}
