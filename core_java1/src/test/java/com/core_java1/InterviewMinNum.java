package com.core_java1;

public class InterviewMinNum {
    
    public static void main(String[] args) {

        int abc [][] = {{5,4,6},{8,2,7},{3,4,9}};
        int min = abc[0][0];

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(abc[i][j] < min)
                {
                    min = abc[i][j];
                }
            }
        }

        System.out.println(min);
    }
}
