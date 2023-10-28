package com.core_java1;

public class ArraysDemo {
    
    public static void main(String[] args) 
    {

        // a container which stores multiple values of same data type

        int a[] = new int[5];  // Declares an array and allocates memory for the value
        a[0] = 5;
        a[1] = 3;
        a[2] = 1;
        a[3] = 13;
        a[4] = 23; // initilised values into that array

        int b[] = {3,4,8,7,9};
        for(int i = 0; i<b.length; i++)
        {
            System.out.println(b[i]);  // retrieve values present in this array
        }
            
    }
}
