package Exercise_30.containers;

import java.util.ArrayList;

/**
 * Exercise 30: Container
 *
 * Object-Oriented Programming with Java Part 2 : 2017-02-16
 */

public class ContainerHistory {                                     // general class to track container history that encapsulates an ArrayList object to track changes
    private ArrayList<Double> historyList;                          // ArrayList to track changes in the container

    public ContainerHistory(){
        historyList = new ArrayList<Double>();
    }

    public void add(double situation) {                             // adds the specified change to the ArrayList
        this.historyList.add(situation);
    }

    public void reset() {                                           // deletes the container history records
        this.historyList.clear();
    }

    public String toString(){
        return this.historyList.toString();
    }

    // returns the greatest value in the container history. If the history is empty, the method returns 0.0
    public double maxValue(){
        if (!this.historyList.isEmpty()){

            double max = this.historyList.get(0);

            for (Double value : this.historyList) {
               if (value > max){
                   max = value;
               }
            }
            return max;

        } else {
            return 0.0;
        }
    }

    // returns the smallest value in the container history. If the history is empty, the method returns 0.0
    public double minValue(){
        if (!this.historyList.isEmpty()){

            double min = this.historyList.get(0);

            for (Double value : this.historyList) {
                if (value < min){
                    min = value;
                }
            }
            return min;

        } else {
            return 0.0;
        }
    }

    // returns the average of the values in the container history. If the history is empty, the method returns 0.0
    public double average() {
        if (!this.historyList.isEmpty()) {
            double sum = 0.0;

            for (Double value : this.historyList) {
                sum += value;
            }

            return sum / this.historyList.size();

        } else {
            return 0.0;
        }
    }

    // returns the absolute value of the single greatest fluctuation in the container history
    public double greatestFluctuation(){
        if (!(this.historyList.isEmpty() || this.historyList.size() == 1)){

            double prevValue;
            double currentValue;
            double difference;
            double maxFluct = 0.0;

            for (int i = 1; i < this.historyList.size(); i++){
                prevValue = this.historyList.get(i - 1);
                currentValue = this.historyList.get(i);
                difference = currentValue - prevValue;

                maxFluct = Math.max(maxFluct, Math.abs(difference));

            }

            return maxFluct;

        } else {
            return 0.0;
        }
    }

    // returns the sample variance of the container history values.
    public double variance(){
        if (!(this.historyList.isEmpty() || this.historyList.size() == 1)){

            double average = average();
            double numerator = 0;

            for (Double value : this.historyList) {
                numerator += Math.pow((value - average), 2);
            }

            return numerator / (this.historyList.size() - 1);

        } else {
            return 0.0;
        }
    }

    public static void main(String[] args){

    }
}
