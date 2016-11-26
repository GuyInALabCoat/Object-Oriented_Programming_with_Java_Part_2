package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class VehicleRegister {
    HashMap<RegistrationPlate, String> owners;

    public VehicleRegister(){
        owners = new HashMap<RegistrationPlate, String>();
    }

    // add the owner of the car which corresponds to the parameter of the registration plate
    public boolean add(RegistrationPlate plate, String owner){
        if (!owners.containsKey(plate)){            // if the car has no owner, add it
            owners.put(plate, owner);
            return true;
        }

        return false;   // else if the car has an owner, returns false
    }

    // returns the car owner which corresponds to the plate number
    public String get(RegistrationPlate plate) {
        if (owners.get(plate) != null) {      // returns the owner of the car if the car is registered
            return owners.get(plate);
        }

        return null;    // if the car is not registered, return null
    }

    // deletes the information connected to the parameter registration plate
    public boolean delete(RegistrationPlate plate){
        if (owners.containsKey(plate)){     // if the information is deleted, return true
            owners.remove(plate);
            return true;
        }

        return false;   // if there was no information connected to the plate in the register, return false
    }

    // Prints out all the registration plates stored
    public void printRegistrationPlates(){
        for (RegistrationPlate plate: owners.keySet()) {
            System.out.println(plate);
        }
    }

    // prints out all the car owners only once regardless of number of cars owned
    public void printOwners(){
        ArrayList<String> people = new ArrayList<>();
        for (String owner: owners.values()) {
            if(!people.contains(owner)){
                people.add(owner);
            }
        }

        for (String person: people) {
            System.out.println(person);
        }
    }

    public static void main(String[] args){
        VehicleRegister register = new VehicleRegister();

        register.add(new RegistrationPlate("FI", "ABC-123"), "Arto");
        register.add(new RegistrationPlate("FI", "UXE-465"), "Jurgen");
        register.add(new RegistrationPlate("AB", "HXE-649"), "Arto");

        register.printRegistrationPlates();
        register.printOwners();
    }
}
