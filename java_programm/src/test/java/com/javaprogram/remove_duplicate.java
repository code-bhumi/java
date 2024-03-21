// Write a program to remove duplicate elements from an array in Java

package com.javaprogram;

class remove_duplicate {
    
    static int removeduplicates(int arr[], int n)  {
            // Return, if array is empty or 
            // contains a single element
            if (n == 0 || n == 1)
                return n;
     
            int[] temp = new int[n];
            int j = 0;
            for (int i = 0; i < n - 1; i++)
                if (arr[i] != arr[i + 1])
                    temp[j++] = arr[i];
     
            temp[j++] = arr[n - 1];
     
           
            for (int i = 0; i < j; i++)
                arr[i] = temp[i];
     
            return j;
    }
     
        // Driver code
        public static void main(String[] args)
        {
            int arr[] = { 1, 1, 12, 8, 4, 9, 4, 8, 12, 15, 15, 3, 1, 9 };
            int n = arr.length;
            n = removeduplicates(arr, n);
    
            for (int i = 0; i < n; i++)
                System.out.print(arr[i] + " ");
        }
}
        


