package com.core_java1;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Claender_demo {
    
    public static void main(String[] args) {
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sd = new SimpleDateFormat("M/d/yyyy hh/mm/ss");
        System.out.println(sd.format(cal.getTime()));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.DAY_OF_YEAR));
        System.out.println(cal.get(Calendar.HOUR_OF_DAY));
        System.out.println(cal.get(Calendar.ALL_STYLES));


    }
}
