package com.exceldriven;

import java.io.IOException;
import java.util.ArrayList;

public class TestSample {
    
    public static void main(String[] args) throws IOException {
        
        Data_driven d = new Data_driven();
        ArrayList data = d.getData("");

        System.out.println(data.get(0));
        System.out.println(data.get(1));
        System.out.println(data.get(2));
        System.out.println(data.get(3));

    }    
}
