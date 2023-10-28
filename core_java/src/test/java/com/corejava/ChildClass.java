package com.corejava;

public class ChildClass extends ParentClassdemo {

    public void audiosystem()
    {
        System.out.println("new audio child");
    }

    public void engine()
    {
        System.out.println("new engine");
    }

    public void colour()
    {
        System.out.println(colour);
    }

    public static void main(String[] args) {

        ChildClass cd = new ChildClass();
        cd.colour();
        cd.engine();
        cd.audiosystem(); // function overriding - both have method same name same signature same parameters.
        
    }
    
}
