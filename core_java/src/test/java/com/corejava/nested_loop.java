package com.corejava;

public class nested_loop {
    
    public static void main(String[] args){

       
        for(int i=1;i<=4;i++)
        {
            System.out.println("outer loop started");

            for(int j=1;j<=4;j++)
            {
                System.out.println("inner loop printed");
                
            }

            System.out.println("outer loop finished");
        }
    }
}
