package com.core_java1;

public class Constructor_demo {

    // name of constructor should be the class name

    // default constructor
    public  Constructor_demo() {

        System.out.println("I am in the constructor");
        System.out.println("I am in the constructor lecture 1");
        
    }

    // parameterized constructor

    public Constructor_demo(int a, int b) {

        System.out.println("I am in the parameterized constructor");
        int c = a+b;
        System.out.println(c);
    }

    public Constructor_demo(String str) {

        System.out.println(str);
    }

    public void getdata() {
            
        System.out.println("i am the Method");
    }

    // will not return a value
    
    
    public static void main(String[] args) {
     
        Constructor_demo cd = new Constructor_demo();
        Constructor_demo cd1 = new Constructor_demo("Hello");
        Constructor_demo pcd = new Constructor_demo(5, 7);

        // whenever you create an object constructor is called
        // block of code whenever an object is created
        
        // if you have not defined any constructor block compiler will call implicit constructor
    }
}
