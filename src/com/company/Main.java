package com.company;

public class Main {
    public static void main(String[] args){
//        Container container = new Container(1000);
//        addSuitcasesFullOfBricks(container);
//        System.out.println(container);

        String input = "1\n" + "HA-LOL\n" + "42\n" + "1\n" + "G-OWAC\n" +
                "101\n" + "2\n" + "HA-LOL\n" + "HEL\n" + "BAL\n" + "2\n" +
                "G-OWAC\n" + "JFK\n" + "BAL\n" + "2\n" + "HA-LOL\n" + "BAL\n" +
                "HEL\n" + "x\n" + "1\n" + "2\n" + "3\n" + "G-OWAC\n" + "x\n";

        Airport airport = new Airport(input);

        airport.start();
    }

    /*public static void addSuitcasesFullOfBricks(Container container){
        for (int i = 4; i <= 100; i++) {
            Thing brick = new Thing("brick", i);
            for (int j = 0; j < 100; j++) {
                Suitcase suitcase = new Suitcase(100);
                suitcase.addThing(brick);
                container.addSuitcase(suitcase);
            }
        }
    }*/
}
