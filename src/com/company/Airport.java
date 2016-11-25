package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class Airport {
    private Scanner reader;
    private String userInput;
    private boolean booleanValue;
    private HashMap<String, Airplanes> fleet;

    public Airport(String input){
        this.reader = new Scanner(input);
        this.fleet = new HashMap<String, Airplanes>();

    }

    private void setInput(String input){
        this.userInput = input;
    }

    private String getInput(){
        return this.userInput;
    }

    private void setValue(boolean value){
        this.booleanValue = value;
    }

    private boolean getValue(){
        return this.booleanValue;
    }

    public void start(){
        System.out.println("Airport panel\n" +
                "----------------------\n");

        this.setValue(true);

        while (getValue()){
            this.setInput(airportOperations());

            switch (getInput()) {
                case "1":
                    System.out.print("Give plane ID: ");
                    String planeID = readInput();
                    System.out.print("Give plane capacity: ");
                    int planeCapacity = Integer.parseInt(readInput());
                    Airplanes airplane = new Airplanes(planeID, planeCapacity);
                    fleet.put(planeID, airplane);
                    System.out.println("");
                    break;
                case "2":
                    System.out.print("Give plane ID: ");
                    String planeName = readInput();
                    System.out.print("Give departure airport code: ");
                    String departure = readInput();
                    System.out.print("Give destination airport code: ");
                    String destination = readInput();
                    fleet.get(planeName).setFlight(departure, destination);
                    System.out.println("");
                    break;
                case "x":
                    this.setValue(false);
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid input!\n");
                    break;
            }
        }

        System.out.println("Flight service\n" +
                "----------------------\n");

        this.setValue(true);

        while (getValue()){
            this.setInput(flightService());

            switch (getInput()) {
                case "1":
                    for (String planeName:fleet.keySet()) {
                        this.fleet.get(planeName).printPlaneInfo();
                    }
                    System.out.println("");
                    break;
                case "2":
                    for (String planeName:fleet.keySet()) {
                        this.fleet.get(planeName).printFlights();
                    }
                    System.out.println("");
                    break;
                case "3":
                    System.out.print("Give plane ID: ");
                    String planeName = readInput();
                    fleet.get(planeName).printPlaneInfo();
                    System.out.println("");
                    break;
                case "x":
                    this.setValue(false);
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid input!\n");
                    break;
            }
        }
    }

    private String airportOperations(){
        System.out.println("Choose operation:\n" +
                "[1] Add airplane\n" +
                "[2] Add flight\n" +
                "[x] Exit");
        return readInput();
    }

    private String readInput(){
        return this.reader.nextLine();
    }

    private String flightService(){
        System.out.println("Choose operation:\n" +
                "[1] Print planes\n" +
                "[2] Print flights\n" +
                "[3] Print plane info\n" +
                "[x] Quit");
        return readInput();
    }
}
