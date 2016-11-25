package com.company;

import java.util.ArrayList;

public class Changer {
    private ArrayList<Change> listOfChanges;

    public Changer(){
        listOfChanges = new ArrayList<Change>();
    }

    public void addChanger(Change change){
        this.listOfChanges.add(change);
    }

    public String change(String characterString){
        for (Change Change : listOfChanges) {
            characterString = Change.change(characterString);
        }

        return characterString;
    }

    public static void main(String[] args){
        Changer scandiesAway = new Changer();
        scandiesAway.addChanger(new Change('ä', 'a'));
        scandiesAway.addChanger(new Change('ö', 'o'));
        System.out.println(scandiesAway.change("ääliö älä lyö, ööliä läikkyy"));
    }
}
