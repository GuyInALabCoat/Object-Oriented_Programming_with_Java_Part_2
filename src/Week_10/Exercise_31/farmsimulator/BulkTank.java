package Exercise_31.farmsimulator;

/**
 * Exercise 31: Farm Simulator
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-17
 */
public class BulkTank {
    public double capacity;
    public double volume;

    public BulkTank(){
        this.capacity = 2000.0;
    }

    public BulkTank(double capacity){
        this.capacity = capacity;
    }

    public double getCapacity(){
        return this.capacity;
    }

    public double getVolume(){
        return this.volume;
    }

    public double howMuchFreeSpace(){
        return this.getCapacity() - this.getVolume();
    }

    public void addToTank(double amount){

        if (amount >= 0){

            if (this.getVolume() + amount <= this.getCapacity()) {
                this.volume += amount;
                this.capacity -= amount;
            } else {
                this.volume += this.capacity;
                this.capacity -= this.capacity;
            }
        } else {
            this.volume += 0.0;
            this.capacity -= 0.0;
        }
    }

    public double getFromTank(double amount){

        if (amount >= 0) {

            if (this.getVolume() >= amount){
                this.volume -= amount;
                this.capacity += amount;
                return amount;
            } else {
                double quantityOfMilk = this.getVolume();
                this.capacity += quantityOfMilk;
                this.volume -= quantityOfMilk;
                return quantityOfMilk;
            }
        } else {
            return 0.0;
        }
    }

    @Override
    public String toString(){
        return Math.ceil(this.getVolume()) + "/" + Math.ceil(this.getCapacity() + this.getVolume());
    }

    public static void main(String[] args){
        // Exercise 31.1 Bulk Tank
        /*BulkTank tank = new BulkTank();
        tank.getFromTank(100);
        tank.addToTank(25);
        tank.getFromTank(5);
        System.out.println(tank);

        tank = new BulkTank(50);
        tank.addToTank(100);
        System.out.println(tank);*/
    }


}
