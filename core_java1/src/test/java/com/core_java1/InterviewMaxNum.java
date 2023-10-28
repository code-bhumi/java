package com.core_java1;

public class InterviewMaxNum {
    
    public static void main(String[] args) {

        int abc [][] = {{2,7,5},{7,8,6},{1,3,9}};
        int max = abc[0][0];

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(abc[i][j] > max)
                {
                    max = abc[i][j];
                }
            }
        }

        System.out.println(max);
    }
}
