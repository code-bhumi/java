package com.corejava;

public class ChildAirIndia extends ParentAirCraft {

    public static void main(String[] args) {

        ChildAirIndia ca = new ChildAirIndia();
        ca.Engine();
        ca.SfteyGuidelines();
        ca.bodycolor();

    }  
    
    @Override
    public void bodycolor() {
        
        System.out.println("red and white body color");
    }

   
    

}
