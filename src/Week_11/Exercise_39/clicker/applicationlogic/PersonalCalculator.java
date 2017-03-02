package Week_11.Exercise_39.clicker.applicationlogic;

/**
 * Exercise 39: Axe Click Effect
 *
 * Object-Oriented Programming with Java Part 2 : 2017-03-02
 */

public class PersonalCalculator implements Calculator{
    private int value;

    public PersonalCalculator(){
        this.value = 0;
    }

    public int giveValue(){
        return this.value;
    }

    public void increase(){
        this.value++;
    }

    public static void main(String[] args){

        Calculator calc = new PersonalCalculator();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
        calc.increase();
        System.out.println("Value: " + calc.giveValue());
    }
}
