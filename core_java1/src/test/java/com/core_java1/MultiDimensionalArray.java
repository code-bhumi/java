package com.core_java1;

public class MultiDimensionalArray {
    
    public static void main(String[] args) {

        // a[row][coloumn]

        int a[][] = new int[2][3];
        a[0][0] = 3;
        a[0][1] = 1;
        a[0][2] = 5;
        a[1][0] = 7;
        a[1][1] = 8;
        a[1][2] = 6;

       /* System.out.println(a[1][2]);

        int b[][] = {{4,8,9},{2,7,3},{3,6,9}};

        System.out.println(b[1][2]); */

        for(int i=0; i<2; i++)              // stands for row
        {
            for(int j=0; j<3; j++)          // stands for coloumn
            {
                System.out.print(a[i][j]);
                System.out.print("\t");
            }
            System.out.println("");
        }
    }
}
