package Exercise_31.farmsimulator;

import static java.lang.System.exit;

/**
 * Exercise 31: Farm Simulator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class MilkingRobot {
    BulkTank tank;

    public MilkingRobot(){
    }

    BulkTank getBulkTank(){
        return this.tank;
    }

    void setBulkTank(BulkTank tank){
        this.tank = tank;
    }

    void milk(Milkable milkable){

        if (this.tank == null){
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }

        this.tank.addToTank(milkable.milk());
    }

    public static void main(String[] args){
        // Exercise 31.3 MilkingRobot
        /*MilkingRobot milkingRobot = new MilkingRobot();
        Cow cow = new Cow();

        BulkTank tank = new BulkTank();
        milkingRobot.setBulkTank(tank);
        System.out.println("Bulk tank: " + tank);

        for(int i = 0; i < 2; i++){
            System.out.println(cow);
            System.out.println("Living..");
            for(int j = 0; j < 5; j++){
                cow.liveHour();
            }
            System.out.println(cow);

            System.out.println("Milking...");
            milkingRobot.milk(cow);
            System.out.println("Bulk tank: " + tank + "\n");
        }*/
    }
}
