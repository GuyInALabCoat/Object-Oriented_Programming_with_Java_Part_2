package Week_10.Exercise_30.containers;

/**
 * Exercise 30: Container
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-16
 */

public class ProductContainerRecorder extends ProductContainer{             // implements ProductContainer and provides services for container history in ContainerHistory object
    private ContainerHistory containerHistory;

    public ProductContainerRecorder(String produceName, double capacity, double initialVolume){ // creates a product container using the given name, capacity and initial volume
        super(produceName, capacity);                                       // call constructor of ProductContainer to create container
        super.addToTheContainer(initialVolume);                             // add the initial volume to the container

        containerHistory = new ContainerHistory();
        containerHistory.add(initialVolume);                                // add the initial addition as the first value in the product history
    }

    public String history(){
        return containerHistory.toString();
    }

    @Override
    public void addToTheContainer(double amount){
        super.addToTheContainer(amount);                                    // add the amount to the container
        this.containerHistory.add(super.getVolume());                       // add the new volume to the container history
    }

    @Override
    public double takeFromTheContainer(double amount){                      // take the amount from the container
        double amountTaken = super.takeFromTheContainer(amount);            // record the new volume in the history
        this.containerHistory.add(super.getVolume());

        return amountTaken;                                                 // return the amount taken
    }

    // prints the history information regarding the product
    public void printAnalysis(){

        System.out.println("Produce: " + super.getName());
        System.out.println("History: " + history());
        System.out.println("Greatest product amount: " + this.containerHistory.maxValue());
        System.out.println("Smallest product amount: " + this.containerHistory.minValue());
        System.out.println("Average: " + this.containerHistory.average());
        System.out.println("Greatest change: " + this.containerHistory.greatestFluctuation());
        System.out.println("Variance: " + this.containerHistory.variance());
    }

    public static void main(String[] args){
        // Exercise 30.6 Product Container Recorder, Phase 1
        /*ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName());    // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);              // Juice: volume = 989.7, free space = 10.3

        // history() does not work properly, yet:
        System.out.println(juice.history());    // [1000.0]
            // in fact, we only retrieve the original value which was given to the constructor.*/

        // Exercise 30.7 Produce Container Recorder, Phase 2
        /*ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        System.out.println(juice.getName());    // Juice
        juice.addToTheContainer(1.0);
        System.out.println(juice);              // Juice: volume = 989.7, free space = 10.3

        // but now we have our history record
        System.out.println(juice.history());    // [1000.0, 988.7, 989.7]*/

        // Exercise 30.8 Product Container Recorder, Phase 3
        /*ProductContainerRecorder juice = new ProductContainerRecorder("Juice", 1000.0, 1000.0);
        juice.takeFromTheContainer(11.3);
        juice.addToTheContainer(1.0);

        juice.printAnalysis();*/
    }
}
