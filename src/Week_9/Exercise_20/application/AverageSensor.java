package Week_9.Exercise_20.application;

import java.util.ArrayList;
import java.util.List;

/**
 * Exercise 20: Sensors and Temperature Measurement
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class AverageSensor implements Sensor{
    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor(){
        sensors = new ArrayList<Sensor>();
        readings = new ArrayList<Integer>();
    }

    public boolean isOn(){                                  // returns false if one of the sensors is turned off
        for (Sensor sensor : sensors) {
            if (!(sensor.isOn())){
                return false;
            } else {
                return true;
            }
        }

        return false;
    }

    public void on(){
        for (Sensor sensor : sensors) {
            sensor.on();
        }
    }

    public void off(){
        for (Sensor sensor : sensors) {
            sensor.off();
        }
    }

    public int measure(){                               // average the readings of all sensors
        int sum = 0;

        if (this.isOn()){
            for (Sensor sensor : sensors) {
                sum += sensor.measure();
            }

            readings.add(sum / sensors.size());                      // add reading to a list of readings

            return (sum / sensors.size());

        } else {
            throw new IllegalStateException("One or more of the sensors is turned off.");
        }


    }

    public void addSensor(Sensor additional){
        sensors.add(additional);
    }

    public List<Integer> readings(){
        return this.readings;
    }

    public static void main(String[] args){
        Sensor kumpula = new Thermometer();
        kumpula.on();
        System.out.println("The temperature in Kumplua is " + kumpula.measure() + " degrees");

        Sensor kaisaniemi = new Thermometer();
        Sensor helsinkiVantaa = new Thermometer();

        AverageSensor helsinkiArea = new AverageSensor();
        helsinkiArea.addSensor(kumpula);
        helsinkiArea.addSensor(kaisaniemi);
        helsinkiArea.addSensor(helsinkiVantaa);

        helsinkiArea.on();
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");
        System.out.println("the temperature in Helsinki area is " + helsinkiArea.measure() + " degrees");

        System.out.println("readings: " + helsinkiArea.readings());
    }
}
