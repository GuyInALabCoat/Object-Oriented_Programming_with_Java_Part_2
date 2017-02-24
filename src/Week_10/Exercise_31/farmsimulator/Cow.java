package Exercise_31.farmsimulator;

import java.util.Random;

/**
 * Exercise 31: Farm Simulator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Cow implements Milkable, Alive{
    private String name;
    private double udderCapacity;
    private double milkVolume;
    private static final String[] NAMES = new String[]{
            "Anu", "Arpa", "Essi", "Heluna", "Hely",
            "Hento", "Hilke", "Hilsu", "Hymy", "Ihq", "Ilme", "Ilo",
            "Jaana", "Jami", "Jatta", "Laku", "Liekki",
            "Mainikki", "Mella", "Mimmi", "Naatti",
            "Nina", "Nyytti", "Papu", "Pullukka", "Pulu",
            "Rima", "Soma", "Sylkki", "Valpu", "Virpi"};

    public Cow(){
        this.name = NAMES[new Random().nextInt(30)];

        udderCapacity = 15 + new Random().nextInt(26);
    }

    public Cow(String name){
        this.name = name;
        udderCapacity = 15 + new Random().nextInt(26);
    }

    String getName(){
        return this.name;
    }

    double getCapacity(){
        return this.udderCapacity;
    }

    double getAmount(){
        return this.milkVolume;
    }

    @Override
    public String toString(){
        return this.getName() + " " + this.getAmount() + "/" + this.getCapacity();
    }

    public double milk(){
        double milkToBeProcessed = this.getAmount();
        this.milkVolume -= milkToBeProcessed;
        return milkToBeProcessed;
    }

    public void liveHour(){
        double milkProduced = 1 + new Random().nextInt(2);

        if (this.getAmount() + milkProduced <= this.udderCapacity){
            this.milkVolume += milkProduced;
        } else {
            this.milkVolume += this.getCapacity() - this.milkVolume;
        }

    }

    public static void main(String[] args) {
        // Exercise 31.2 Cow
        /*Cow cow = new Cow();
        System.out.println(cow);

        Alive livingCow = cow;
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();
        livingCow.liveHour();

        System.out.println(cow);

        Milkable milkingCow = cow;
        milkingCow.milk();

        System.out.println(cow);

        cow = new Cow("Ammu");
        System.out.println(cow);
        cow.liveHour();
        cow.liveHour();
        System.out.println(cow);
        cow.milk();
        System.out.println(cow);*/
    }
}

