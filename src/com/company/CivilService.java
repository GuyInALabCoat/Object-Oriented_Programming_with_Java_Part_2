package com.company;

public class CivilService implements NationalService{
    private int daysLeft;

    public CivilService(){          // object variable daysLeft is initialized to 362 by constructor
        this.daysLeft = 362;
    }

    public int getDaysLeft(){
        return this.daysLeft;
    }

    public void work(){             // as long as daysLeft is not zero, decrement daysLeft by 1
        if(this.getDaysLeft() != 0){
            this.daysLeft--;
        }
    }

    public static void main(String[] args){
        CivilService service = new CivilService();

        System.out.println(service.getDaysLeft());
        service.work();
        System.out.println(service.getDaysLeft());

        while(service.getDaysLeft() != 0){
            service.work();
        }

        System.out.println(service.getDaysLeft());

    }
}
