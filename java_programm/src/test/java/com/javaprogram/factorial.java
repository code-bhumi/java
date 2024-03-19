// Write a program to find the factorial of a given number in Java.

package com.javaprogram;

public class factorial {
    
    public static void main(String args[]) {

            int num = 5;
            int fact = 1;
            for (int i = 1; i <= num; i++) 
            {
                fact *= i;
            }
            System.out.println("Factorail of " + num + " is " + fact);
    }
}
