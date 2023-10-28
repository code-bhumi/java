package com.core_java1;

public class thisDemo {

    int a = 2;

    public void getdata()
    {
        int a = 3;
        int b = a + this.a;
        System.out.println(a);
        System.out.println(this.a);
        System.out.println(b);
    }
    
    public static void main(String[] args) {

        thisDemo td = new thisDemo();
        td.getdata();

    }
}
