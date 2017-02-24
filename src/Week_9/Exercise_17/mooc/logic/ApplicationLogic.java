package Week_9.Exercise_17.mooc.logic;

import Week_9.Exercise_17.mooc.ui.UserInterface;

/**
 * Exercise 17: First Packages
 *
 * Object-Oriented Programming with Java Part 2 : 2017-01-10
 */
public class ApplicationLogic {
    private UserInterface userInterface;

    public ApplicationLogic(UserInterface ui){
        this.userInterface = ui;
    }

    public void execute(int howManyTimes){
        for(int i = 0; i < howManyTimes; i++){
            System.out.println("The application logic works");
            this.userInterface.update();
        }
    }
}
