// A Fibonacci sequence is one in which each number is the sum of the two previous numbers

package com.javaprogram;

public class fibonacci {

    static void Fibonacci(int N)
    {
        int num1 = 0, num2 = 1;
        for (int i = 0; i < N; i++) {
            System.out.println(num1 + " ");

            // swap
            int num3 = num2 + num1;
            num1 = num2;
            num2 = num3;
        }
    }
    
    // Driver code
    public static void main(String args[]) {

        // given number N
        int N = 10;

        // function call
        Fibonacci(N);

    } 
}
