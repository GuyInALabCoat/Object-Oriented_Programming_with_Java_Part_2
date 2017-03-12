package Week_12.Exercise_46.reference;

import Week_12.Exercise_46.reference.comparator.FilmComparator;
import Week_12.Exercise_46.reference.comparator.PersonComparator;
import Week_12.Exercise_46.reference.domain.Film;
import Week_12.Exercise_46.reference.domain.Person;
import Week_12.Exercise_46.reference.domain.Rating;

import java.util.*;

/**
 * Exercise 46: Film Reference
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-09
 */

// Recommends a film for a person who has never evaluated any movie
public class Reference {
    private RatingRegister ratings;
    private List<Film> filmList;

    // receives a register with films and their ratings
    public Reference(RatingRegister register){
        this.ratings = register;
        this.filmList = getAvailableFilms();
    }

    public Film recommendFilm(Person person){

        if (this.filmList.size() == 0) {
            return null;
        } else {

            // if a person hasn't evaluated any film, recommend them a film according to film ratings
            if (this.ratings.getPersonalRatings(person) == null) {

                // get the map of films and their ratings from the register
                Map<Film, List<Rating>> filmRatings = this.ratings.filmRatings();

                // get the list of films in the register
                List<Film> availableFilms = getAvailableFilms();

                // sort the list according to the film comparator (positive - negative)
                Collections.sort(availableFilms, new FilmComparator(filmRatings));

                // return the first entry in the sorted list
                return availableFilms.get(0);

            } else {        // recommend them a film according to similarity with other people

                Person similarPerson = findMostSimilarPerson(person);

                if (similarPerson == null) {
                    return null;
                } else {

                    List<Film> personalFilms = new ArrayList<>(this.ratings.getPersonalRatings(similarPerson).keySet());
                    List<Film> conflictingFilms = new ArrayList<>(this.ratings.getPersonalRatings(person).keySet());

                    personalFilms.removeAll(conflictingFilms);

                    Map<Film, List<Rating>> personalRatings = new HashMap<>();

                    for (Film film : personalFilms) {
                        List<Rating> personalRating = new ArrayList<>();
                        personalRating.add(this.ratings.getRating(similarPerson, film));
                        personalRatings.put(film, personalRating);
                    }

                    Collections.sort(personalFilms, new FilmComparator(personalRatings));

                    return personalFilms.get(0);
                }

            }
        }
    }

    // return the list of films from the register
    private List<Film> getAvailableFilms(){

        List<Film> films = new ArrayList<>();

        for (Film film : this.ratings.filmRatings().keySet()) {
            films.add(film);
        }

        return films;
    }

    public Person findMostSimilarPerson(Person person){

        Map<Person, Integer> similarPeople = new HashMap<>();
        List<Person> similarReviewers = new ArrayList<>();

        for (Person reviewer : this.ratings.reviewers()) {

            int similarity = 0;

            if (!reviewer.equals(person)){

                Map<Film, Rating> personalRatings = this.ratings.getPersonalRatings(person);
                Map<Film, Rating> reviewerRating = this.ratings.getPersonalRatings(reviewer);

                for (Film film : personalRatings.keySet()) {

                    if (reviewerRating.containsKey(film)){

                        similarity += personalRatings.get(film).getValue() * reviewerRating.get(film).getValue();

                    }
                }

                if (appropriatePerson(person, reviewer)) {
                    similarPeople.put(reviewer, similarity);
                    similarReviewers.add(reviewer);
                }
            }
        }

        try {

            Collections.sort(similarReviewers, new PersonComparator(similarPeople));

            return similarReviewers.get(0);
            
        } catch (Exception e){
            return null;
        }
    }

    private boolean appropriatePerson(Person person, Person reviewer){

        boolean test = false;

        for (Film film : this.filmList) {
            if (this.ratings.getRating(person, film).equals(Rating.NOT_WATCHED) &&
                    this.ratings.getRating(reviewer, film).getValue() > 1){
                test = true;
            }
        }

        return test;
    }

    public static void main(String[] args){

        RatingRegister ratings = new RatingRegister();

        Film goneWithTheWind = new Film("Gone with the Wind");
        Film theBridgesOfMadisonCounty = new Film("The Bridges of Madison County");
        Film eraserhead = new Film("Eraserhead");
        Film bluesBrothers = new Film("Blues Brothers");

        Person matti = new Person("Matti");
        Person pekka = new Person("Pekka");
        Person mikke = new Person("Mikael");
        Person thomas = new Person("Thomas");
        Person arto = new Person("Arto");

        ratings.addRating(matti, goneWithTheWind, Rating.BAD);
        ratings.addRating(matti, theBridgesOfMadisonCounty, Rating.GOOD);
        ratings.addRating(matti, eraserhead, Rating.FINE);

        ratings.addRating(pekka, goneWithTheWind, Rating.FINE);
        ratings.addRating(pekka, eraserhead, Rating.BAD);
        ratings.addRating(pekka, bluesBrothers, Rating.MEDIOCRE);

        ratings.addRating(mikke, eraserhead, Rating.BAD);

        ratings.addRating(thomas, bluesBrothers, Rating.GOOD);
        ratings.addRating(thomas, theBridgesOfMadisonCounty, Rating.GOOD);

        Reference ref = new Reference(ratings);

        System.out.println(thomas + " recommendation: " + ref.recommendFilm(thomas));
        System.out.println(mikke + " recommendation: " + ref.recommendFilm(mikke));
        System.out.println(matti + " recommendation: " + ref.recommendFilm(matti));
        System.out.println(arto + " recommendation: " + ref.recommendFilm(arto));
    }
}
