package Week_10.Exercise_31.farmsimulator;

import java.util.LinkedList;

/**
 * Exercise 31: Farm Simulator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class Barn {
    private BulkTank bulkTank;
    private MilkingRobot milkingRobot;

    public Barn(BulkTank tank){
        this.bulkTank = tank;
    }

    public BulkTank getBulkTank(){
        return this.bulkTank;
    }

    public void installMilkingRobot(MilkingRobot milkingRobot){
        this.milkingRobot = milkingRobot;
        this.milkingRobot.setBulkTank(this.bulkTank);
    }

    public void takeCareOf(Cow cow){

        if (this.milkingRobot == null){
            throw new IllegalStateException("The MilkingRobot has not been installed");
        }

        this.milkingRobot.milk(cow);
    }

    @Override
    public String toString(){
        return bulkTank.toString();
    }

    public static void main(String[] args){
        // Exercise 31.4 Barn
        /*Barn barn = new Barn(new BulkTank());
        System.out.println("Barn: " + barn);

        MilkingRobot robot = new MilkingRobot();
        barn.installMilkingRobot(robot);

        Cow ammu = new Cow();
        ammu.liveHour();
        ammu.liveHour();

        barn.takeCareOf(ammu);
        System.out.println("Barn: " + barn);

        LinkedList<Cow> cowList = new LinkedList<Cow>();
        cowList.add(ammu);
        cowList.add(new Cow());

        for (Cow cow: cowList) {
            cow.liveHour();
            cow.liveHour();
            barn.takeCareOf(cow);
        }

        System.out.println("Barn: " + barn);*/
    }
}
