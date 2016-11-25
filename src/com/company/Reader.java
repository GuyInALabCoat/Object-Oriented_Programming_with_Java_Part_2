package com.company;

import java.util.Scanner;

public class Reader {
    Scanner scanner = new Scanner(System.in);

    public String readString(){
        return scanner.nextLine();
    }

    public int readInteger(){
        return Integer.parseInt(readString());
    }
}
