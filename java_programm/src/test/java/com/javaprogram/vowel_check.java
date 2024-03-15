// write a programming to check if a vowel is present in the string

package com.javaprogram;

public class vowel_check {
    
    public static void main(String[] args) 
    {
        System.out.println(stringContainsVowels("Apple"));
        System.out.println(stringContainsVowels("qwth"));
    }

    public static boolean stringContainsVowels(String input) 
    {
        return input.toLowerCase().matches(".*[aeiou].*");
    }
}
