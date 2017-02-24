package Week_10.Exercise_27;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Exercise 27: Ringing Centre
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-15
 */

public class RingingCentre {
    private Map<Bird, List<String>> birdSightings;

    public RingingCentre(){
        birdSightings = new HashMap<Bird, List<String>>();
    }

    // records the observation and its location
    public void observe(Bird bird, String place){


        // when creating a new entry in a map, an empty list must be mapped to it first.
        if (!(this.birdSightings.containsKey(bird))){
            this.birdSightings.put(bird, new ArrayList<String>());
            this.birdSightings.get(bird).add(place);                        // a String can now be added to the new empty mapping
        }else {
            this.birdSightings.get(bird).add(place);
        }
    }

    // prints all observations of given bird
    public void observations(Bird bird){
        try {
            System.out.println(bird + "observations: " + this.birdSightings.get(bird).size());

            for (String location : this.birdSightings.get(bird)) {
                System.out.println(location);
            }
        } catch (NullPointerException e){                                   // if a bird does not exist in the HashMap, simply print that it has been observed 0 times
            System.out.println(bird + "observations: " + 0);
        }
    }

    public static void main(String[] args){
        RingingCentre kumpulaCentre = new RingingCentre();

        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2012), "Arabia");
        kumpulaCentre.observe( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012), "Vallila");
        kumpulaCentre.observe( new Bird("European Herring Gull", "Larus argentatus", 2008), "Kumpulanmaki");
        kumpulaCentre.observe( new Bird("Rose Starling", "Sturnus roseus", 2008), "Mannerheiminhtie");

        kumpulaCentre.observations( new Bird("Rose-Coloured Starling", "Sturnus roseus", 2012));
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 2008));
        System.out.println("--");
        kumpulaCentre.observations( new Bird("European Herring Gull", "Larus argentatus", 1980));

    }
}
