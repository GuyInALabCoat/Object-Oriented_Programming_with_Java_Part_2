package Week_10.Exercise_32.boxes;

/**
 * Exercise 32: Different Boxes
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-18
 */

public class OneThingBox extends Box{
    private Thing oneThing;

    public OneThingBox(){
    }

    @Override
    public void add(Thing thing){
        if (this.oneThing == null){
            this.oneThing = thing;
        }
    }

    @Override
    public boolean isInTheBox(Thing thing){
        if (this.oneThing.equals(thing)){
            return true;
        }

        return false;
    }

    public static void main(String[] args){
        // Exercise 32.3 One-Thing Box
        OneThingBox box = new OneThingBox();
        box.add(new Thing("Saludo", 5));
        box.add(new Thing("Pirkka", 5));

        System.out.println(box.isInTheBox(new Thing("Saludo")));
        System.out.println(box.isInTheBox(new Thing("Pirkaa")));
    }
}
