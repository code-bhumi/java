// Write a program to check if a given number is prime in Java.

package com.javaprogram;

public class prime_num_check {
    
    public static void main(String[] args) 
    {
        int num = 8;
        boolean isPrime = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println(num + " " + "is a prime number. ");
        }
        else {
            System.out.println(num + " " + "is not a prime number. ");
        }
    }
}
