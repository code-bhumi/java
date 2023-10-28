package com.corejava;

// function overloading
// either argument count should be different or
// argument data type should be different

public class ChildLevel extends ChildClass {

    public void getdata(int a)
    {
        System.out.println(a);
    }

    public void getdata(String a)
    {
        System.out.println(a);
    }

    public void getdata(int a, int b)
    {
        System.out.println(b);
    }
    
    public static void main(String[] args) {

        ChildLevel cl = new ChildLevel();
        cl.getdata(5);
        cl.getdata(13, 23);
        cl.getdata("......I love my Krishna.......");

    }

}
