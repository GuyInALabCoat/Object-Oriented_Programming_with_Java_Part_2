package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class RegistrationPlate {
    // ATTENTION: the object variable types are final, meaning that their value cannot be changed.
    private final String regCode;
    private final String country;

    public RegistrationPlate(String country, String regCode){
        this.regCode = regCode;
        this.country = country;
    }

    public String getRegCode(){
        return this.regCode;
    }

    public String getCountry(){
        return this.country;
    }

    @Override
    public String toString(){
        return country + " " + regCode;
    }


    // Override the equals method to return true if the contents of two objects are the same
    @Override
    public boolean equals(Object object){
        if(object == null){                     // Objects are not the same if parameter object is null
            return false;
        }

        if (this.getClass() != object.getClass()){  // Objects are not the same if the object types are different
            return false;
        }

        RegistrationPlate comparedObject = (RegistrationPlate) object;  // type cast the parameter object to type RegistrationPlate

        if (this.country != comparedObject.getCountry()){       // Objects are not the same if the country object variables is different
            return false;
        }

        if(this.regCode == null || !this.regCode.equals(comparedObject.getRegCode())){      // If this object's regCode is not null and the regCodes are the same, the Objects are equal
            return false;
        }

        return true;
    }

    @Override
    public int hashCode(){
        if (this.country == null){      // set a return condition in the case that country object variable is null
            return -1;
        }

        return this.country.hashCode() + this.regCode.hashCode();
    }

    public static void main(String[] args){
        RegistrationPlate reg1 = new RegistrationPlate("FI", "ABC-123");
        RegistrationPlate reg2 = new RegistrationPlate("FI", "UXE-465");
        RegistrationPlate reg3 = new RegistrationPlate("D", "B WQ-431");

        ArrayList<RegistrationPlate> finnish = new ArrayList<RegistrationPlate>();
        finnish.add(reg1);
        finnish.add(reg2);

        RegistrationPlate New = new RegistrationPlate("FI", "ABC-123");
        if (!finnish.contains(New)){
            finnish.add(New);
        }

        System.out.println("Finnish: " + finnish);
        // if the equals method hasn't been overwritten, the same registration plate is repeated in the list

        HashMap<RegistrationPlate, String> owners = new HashMap<RegistrationPlate, String>();
        owners.put(reg1, "Arto");
        owners.put(reg3, "Jurgen");

        System.out.println("owners:");
        System.out.println(owners.get(new RegistrationPlate("FI", "ABC-123")));
        System.out.println(owners.get(new RegistrationPlate("D", "B WQ-431")));
        // if the hashCode hasn't been overwritten, the owners are not found
    }
}
