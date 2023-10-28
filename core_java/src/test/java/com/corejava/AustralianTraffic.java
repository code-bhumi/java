package com.corejava;

public class AustralianTraffic implements Central_Traffic, ContinentalTraffic {
    
    public static void main(String[] args) {

        Central_Traffic a = new AustralianTraffic();
        a.RedStop();
        a.GreenGo();
        a.FlashYellow();
        
        AustralianTraffic at = new AustralianTraffic();
        at.WalkonSymbol();

        ContinentalTraffic ct = new AustralianTraffic();
        ct.TrainSymbol();

    }

    @Override
    public void GreenGo() {
        
        System.out.println("GreenGo implementation");
    }

    @Override
    public void RedStop() {
        
        System.out.println("Redstop implementation");
    }

    @Override
    public void FlashYellow() {
        
        System.out.println("FlashYellow implementation");

    }

    public void WalkonSymbol() {

        System.out.println("Walking implementation");
    }

    @Override
    public void TrainSymbol() {
        
        System.out.println("TrainSymbol implementation");
    }
}
