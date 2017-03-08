package Week_10.Exercise_30.containers;

/**
 * Exercise 30: Container
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-16
 */

public class ProductContainer extends Container{                        // class to handle products and product names

    private String productName;

    public ProductContainer(String productName, double capacity){       // creates an empty product container with the given capacity and name
        super(capacity);
        this.productName = productName;
    }

    public String getName(){
        return this.productName;
    }

    public void setName(String newName){
        this.productName = newName;
    }

    @Override
    public String toString(){
        return this.getName() + ": " + super.toString();
    }

    public static void main(String[] args){
        // Exercise 30.1 Product Container, Phase 1
        /*ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName()); // Juice
        System.out.println(juice);           // volume = 988.7, free space 11.3*/

        // Exercise 30.2 Product Container, Phase 2
        /*ProductContainer juice = new ProductContainer("Juice", 1000.0);
        juice.addToTheContainer(1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName());    // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);              // Juice: volume = 989.7, space = 10.3*/
    }
}
