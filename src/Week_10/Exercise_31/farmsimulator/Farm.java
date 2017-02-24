package Exercise_31.farmsimulator;

import java.util.LinkedList;

/**
 * Exercise 31: Farm Simulator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Farm implements Alive{
    private String owner;
    private Barn barn;
    private LinkedList<Cow> herdOfCows;

    public Farm(String name, Barn barn){
        this.owner = name;
        this.barn = barn;
        this.herdOfCows = new LinkedList<Cow>();
    }

    public void liveHour(){
        for (Cow cow: this.herdOfCows) {
            cow.liveHour();
        }
    }

    void manageCows(){
        for (Cow cow: this.herdOfCows) {
            this.barn.takeCareOf(cow);
        }
    }

    void addCow(Cow cow){
        this.herdOfCows.add(cow);
    }

    void installMilkingRobot(MilkingRobot robot){
        this.barn.installMilkingRobot(robot);
    }

    String getHerdOfCows() {
        StringBuilder newString = new StringBuilder();

        if (this.herdOfCows.isEmpty()) {
            return "No cows.";
        } else {
            for (Cow cow : this.herdOfCows) {
                newString.append("\t" + cow.toString() + "\n");
            }
        }

        return "Animals:\n" + newString.toString();
    }

    String getOwner(){
        return this.owner;
    }

    @Override
    public String toString(){
        return "Farm owner: " + this.getOwner() + "\n" + "Barn bulk tank: " + this.barn.toString() + "\n" + this.getHerdOfCows();
    }

    public static void main(String[] args){
        Farm farm = new Farm("Esko", new Barn(new BulkTank()));
        MilkingRobot robot = new MilkingRobot();
        farm.installMilkingRobot(robot);

//        System.out.println(farm);

//        System.out.println(farm.getOwner() + " is a tough guy!");

        farm.addCow(new Cow());
        farm.addCow(new Cow());
        farm.addCow(new Cow());

        farm.liveHour();
        farm.liveHour();

        farm.manageCows();

        System.out.println(farm);
    }
}
