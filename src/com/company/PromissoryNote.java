package com.company;

import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> promissoryNote;

    public PromissoryNote(){
        promissoryNote = new HashMap<String, Double>();
    }

    public void setLoan(String toWhom, double value){
        this.promissoryNote.put(toWhom, value);
    }

    public double howMuchIsTheDebt(String whose){
        if (this.promissoryNote.containsKey(whose)){
            return this.promissoryNote.get(whose);
        }

        return 0;
    }

    public static void main(String[] args){
        PromissoryNote mattisNote = new PromissoryNote();
        mattisNote.setLoan("Arto", 51.5);
        mattisNote.setLoan("Mikael", 30);

        System.out.println(mattisNote.howMuchIsTheDebt("Arto"));
        System.out.println(mattisNote.howMuchIsTheDebt("Joel"));
    }
}
