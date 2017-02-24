package Week_9.Exercise_20.application;

/**
 * Exercise 20: Sensors and Temperature Measurement
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class ConstantSensor implements Sensor{
    private int reading;

    public ConstantSensor(int value){
        this.reading = value;
    }

    public boolean isOn(){
        return true;                                // always on
    }

    public void on(){
        // do nothing
    }

    public void off(){
        // do nothing
    }

    public int measure(){
        return this.reading;
    }

    public static void main(String[] args){
        // Exercise 20.1 Constant Sensor

        ConstantSensor ten = new ConstantSensor(10);
        ConstantSensor minusFive = new ConstantSensor(-5);

        System.out.println(ten.measure());
        System.out.println(minusFive.measure());

        System.out.println(ten.isOn());
        ten.off();
        System.out.println(ten.isOn());
    }
}
