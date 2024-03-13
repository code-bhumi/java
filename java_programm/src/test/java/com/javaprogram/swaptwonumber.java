// Swapping numbers without using a third variable 

package com.javaprogram;

public class swaptwonumber {

    public static void main(String[] args) {
        
        int a = 10;
        int b = 20;

        System.out.println("a is " + a + " and b is " + b);

        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("after swapping, a is " + a + " and b is " + b);

    }
    
}
