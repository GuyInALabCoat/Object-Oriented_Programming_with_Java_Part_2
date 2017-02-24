package Exercise_30.containers;

/**
 * Exercise 30: Container
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-16
 */

public class Container {                            // General class for all types of containers
    private final double originalCapacity;
    private double currentCapacity;
    private double volume;


    public Container(double capacity){

        if (capacity >= 0){                         // if given capacity is a valid capacity (equal to or greater than 0)
            this.currentCapacity = capacity;        // set current capacity to passed value
            this.originalCapacity = capacity;       // set original capacity as a constant to passed value
        } else {
            this.originalCapacity = 0;              // if given capacity is less than 0
            this.currentCapacity = 0;               // set the capacity to 0
        }

        this.volume = 0;                            // by default the initial volume of the product in the container is 0

    }

    public double getVolume(){
        return this.volume;
    }

    public double getOriginalCapacity(){
        return this.originalCapacity;
    }

    public double getCurrentCapacity(){
        return this.currentCapacity;
    }

    public void addToTheContainer(double amount){

        if (amount >= 0){                           // if the amount to add is negative, nothing changes

            if (amount <= getCurrentCapacity()){    // if the amount to add is less than or equal to the available capacity of the container
                this.volume += amount;              // simply add the amount to the container
                this.currentCapacity -= amount;     // the new capacity is now the available capacity - the amount added
            } else {
                this.volume += getCurrentCapacity();            // if the amount is greater than the available capacity. Simply fill the remaining capacity and discard any excess
                this.currentCapacity -= getCurrentCapacity();   // the available capacity is therefore set to 0
            }
        }
    }

    public double takeFromTheContainer(double amount){

        if (amount >= 0 && amount <= getVolume()){  // if the amount is less than the available volume of product but greater than 0
            this.volume -= amount;                  // remove that amount of product from the container
            this.currentCapacity += amount;         // increase the available capacity by the amount taken
            return amount;
        } else if (amount > getVolume()){           // if the amount is greater than the available volume of product
            double product = this.getVolume();      // find the total amount of product available
            this.currentCapacity += product;        // increase the available capacity by the amount of product
            this.volume -= product;                 // remove that amount of product from the container
            return product;                         // return all available product
        } else {
            return 0;                               // if the amount specified is less than 0, simply return 0
        }
    }

    @Override
    public String toString(){
        return "volume = " + getVolume() + ", free space " + getCurrentCapacity();
    }
}
