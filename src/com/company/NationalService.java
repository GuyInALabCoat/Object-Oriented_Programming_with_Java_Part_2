package com.company;

public interface NationalService {
    int getDaysLeft();  // returns the number of days left on service
    void work();        // reduces the working days by one. working days cannot be negative
}
