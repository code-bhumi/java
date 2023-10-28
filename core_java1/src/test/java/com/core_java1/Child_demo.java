package com.core_java1;

public class Child_demo extends Parent_demo {

    String name = "QAClickacademy";

    public void getStringdata() 
    {
        System.out.println(name);
        System.out.println(super.name);
    }

    public void getdata()
    {
        super.getdata();
        System.out.println("I am child class");
    }

    public Child_demo()
    {
        super();
        System.out.println("i am child class constructor");
    }
    public static void main(String[] args) {

        Child_demo cd = new Child_demo();
        cd.getStringdata();
        cd.getdata();
       
    }
}
