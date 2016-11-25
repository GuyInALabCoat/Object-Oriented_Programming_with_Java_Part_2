package com.company;

public class Flights {
    private String flight;


    public Flights(String departure, String destination){
        flight = "(" + departure + "-" + destination + ")";
    }

    @Override
    public String toString(){
        return this.flight;
    }
}
