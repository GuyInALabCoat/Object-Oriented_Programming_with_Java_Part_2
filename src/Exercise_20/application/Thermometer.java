package Exercise_20.application;

import java.util.Random;

/**
 * Exercise 20: Sensors and Temperature Measurement
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-12
 */

public class Thermometer implements Sensor{
    private int state;                          // 0 = off, 1 = on
    private Random random;

    public Thermometer(){
        random = new Random();
        this.state = 0;
    }

    public boolean isOn(){
        if (this.state == 0){
            return false;
        } else {
            return true;
        }
    }

    public void on(){
        this.state = 1;
    }

    public void off(){
        this.state = 0;
    }

    public int measure(){
        if (this.state == 1){
            return (random.nextInt(60) - 30);
        } else {
            throw new IllegalStateException("Thermometer must be on before it can be measured");
        }
    }
}
