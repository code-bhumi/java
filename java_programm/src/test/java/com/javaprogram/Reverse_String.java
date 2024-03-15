package com.javaprogram;

public class Reverse_String {
    
     public static void main(String[] args) {
        
        String str = "ABCDEF";

        StringBuffer strbuff = new StringBuffer(str);

        // to reverse the string

        strbuff.reverse();

        System.out.println(strbuff);


     }
}

