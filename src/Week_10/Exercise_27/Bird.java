package Week_10.Exercise_27;

/**
 * Exercise 27: The Ringing Centre
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-15
 */

public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear){
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public String toString(){
        return this.latinName + " (" + this.ringingYear + ") ";
    }

    public boolean equals(Object other) {

        if (this == other) {                                     // compare this object to the passed object to see if they are equal, and return true if they are the same
            return true;
        }
        if ((other == null) || other.getClass() != this.getClass()) {     // check if passed object is null, if not
            return false;                                               // then compare if the object are of the same type by checking each of their classes. They are equal if and only if they are not null and of the same type
        }

        final Bird bird = (Bird) other;                                 // Important: Cast the other object to the object you want to compare to, so you have access to the field of that class.
        return (this.ringingYear == bird.ringingYear &&                 // finally compare the objects to compare if the two fields, latin name and observation year are the same,
                (this.latinName != null && this.latinName.equals(bird.latinName)));     // two birds are only the same if those two fields are equal.
    }

    @Override
    public int hashCode(){
        int hash = 13;                                          // choose and arbitrary int variable;
        hash = 27 * hash + this.ringingYear;                    // involve the fields used in the equals method to generate a new hash value
        hash = 41 * hash + (null == this.latinName ? 0 : this.latinName.hashCode());    // special conditional operator that testes the conditional expression (a == b),
        return hash;                                                                    // if true, then it returns a, and if it is false, it returns b.
    }                                                                                   // in this case, it will not produce an error even if the latin name is null

    public static void main(String[] args){
        Bird bird1 = new Bird("Rose Starling", "Sturnus roseus", 2012);
        Bird bird2 = new Bird("Rose-Cloured Starling", "Sturnus roseus", 2012);
        Bird bird3 = new Bird("Hooded Crow", "Corvus corone cornix", 2012);
        Bird bird4 = new Bird("Rose-Coloured Pastor", "Sturnus roseus", 2000);

        System.out.println( bird1.equals(bird2)); // same Latin name and same observation year: they are the same bird
        System.out.println( bird1.equals(bird3)); // different Latin name: they are not the same bird
        System.out.println( bird1.equals(bird4)); // different observation year: not the same bird
        System.out.println( bird1.hashCode()==bird2.hashCode());
    }
}
