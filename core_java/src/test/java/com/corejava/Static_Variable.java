package com.corejava;

public class Static_Variable {
    
    String name;   // instance variable
    String street;
    static String city;  // class variable , static method will only accept static variable
    static int i; 
    static {

        city = "Haridwar";
        i = 0;
    }  

    Static_Variable(String name, String street)
    {
        this.name = name;
        this.street = street;
        i++;
        System.out.println(i);
        
    }

    public void getstreet()
    {
        System.out.println(street + " " + city);
    }
    
    public static void getCity()
    {
        System.out.println(city);
    } 

    public static void main(String[] args) {

        Static_Variable obj = new Static_Variable("dimple", "yogi vihar");
        Static_Variable obj1 = new Static_Variable("mamta", "hari nagar");
        obj.getstreet();
        obj1.getstreet();
        Static_Variable.getCity();



        // static keywords don't need object to call you can call them with class name . method name

    }
}
