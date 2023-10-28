package com.core_java1;

public class max_of_mincolumn {
    
    public static void main(String[] args) {

        int abc [][] = {{5,4,6},{8,0,7},{3,10,9}};
        int min = abc[0][0];
        int mincoloumn = 0;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(abc[i][j] < min)
                {
                    min = abc[i][j];
                    mincoloumn = j;
                }
            }
        }

        int max = abc[0][mincoloumn];
        int k = 0;
        while(k<3)
        {
            if (abc[k][mincoloumn] > max)
            {
                max = abc[k][mincoloumn];
            }
            k++;
        }

        System.out.println(max);
    }
}
