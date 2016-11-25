package com.company;

import java.util.ArrayList;

public class Airplanes {
    private ArrayList<Flights> flights;
    private int capacity;
    private String ID;

    public Airplanes(String planeID, int planeCapacity){
        this.capacity = planeCapacity;
        this.ID = planeID;
        this.flights = new ArrayList<Flights>();
    }

    public void setFlight(String departure, String destination){
        Flights flight = new Flights(departure, destination);
        this.flights.add(flight);
    }

    public Flights getFlight(Flights flight){
        if (flights.contains(flight)){
            return flight;
        } else {
            return null;
        }
    }

    public void printPlaneInfo(){
        System.out.println(this.ID + " (" + this.capacity + " ppl)");
    }

    public void printFlights(){
        for (Flights flight:flights) {
            System.out.println(this.ID + " (" + this.capacity + " ppl) " + flight.toString());
        }
    }


}

