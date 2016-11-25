package com.company;

public class Calculator {
    int statistics;
    Reader reader;

    public Calculator(){
        reader = new Reader();
        this.statistics = 0;
    }
    public void start(){

        while (true) {
            System.out.print("command: ");
            String command = reader.readString();
            if (command.equals("end")){
                break;
            }

            if (command.equals("sum")){
                sum();
            } else if (command.equals("difference")){
                difference();
            } else if (command.equals("product")){
                product();
            }
        }

        statistics();
    }

    private void sum(){
        int[] array = userInput();
        System.out.println("sum of the values " + (array[0] + array[1]) + "\n");
        this.statistics++;
    }

    private void difference(){
        int[] array = userInput();
        System.out.println("difference of the values " + (array[0] - array[1]) + "\n");
        this.statistics++;

    }

    private void product(){
        int[] array = userInput();
        System.out.println("product of the values " + (array[0] * array[1]) + "\n");
        this.statistics++;

    }

    private void statistics(){
        System.out.println("Calculations done " + this.statistics);
    }

    private int[] userInput(){
        int[] input = new int[2];
        System.out.print("value1: ");
        input[0] = reader.readInteger();
        System.out.print("value2: ");
        input[1] = reader.readInteger();

        return input;
    }
}
