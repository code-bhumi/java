package com.javaprogram;

public class leap_year {
    
    public static void main(String args[]) {
    // year to be checked

    int year = 1985;
    boolean leap = false;

    if (year % 4 == 0) {
        // if the year is century
        if (year % 100 == 0){

            if (year % 400 == 0)
                leap = true;
            else
                leap = false;
        }
        else
          leap = true;
        }
        else
          leap = false;

        if (leap)
           System.out.println(year + " is a leap year. ");
        else
           System.out.println(year + " is not a leap year. ");
    }
}