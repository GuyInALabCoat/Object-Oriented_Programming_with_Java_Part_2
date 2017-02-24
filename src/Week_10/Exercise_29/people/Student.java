package Week_10.Exercise_29.people;

/**
 * Exercise 29: Person and their Heirs
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-08
 */

public class Student extends Person{
    private int credits;

    public Student(String name, String address){
        super(name, address);
    }

    public int credits(){
        return this.credits;
    }

    public void study(){
        this.credits++;
    }

    @Override
    public String toString(){
        return super.toString() + "\n  credits " + this.credits();
    }

    public static void main(String[] args){
        Student olli = new Student("Olli", "Ida Albergintie Street 1 00400 Helsinki");

        // Exercise 29.2

        /*System.out.println(olli);
        System.out.println("credits " + olli.credits());
        olli.study();
        System.out.println("credits " + olli.credits());*/

        // Exercise 29.3
        System.out.println( olli );
        olli.study();
        System.out.println( olli );
    }
}
