package com.core_java1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Date_demo {
    
    public static void main(String[] args) {

        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("M/dd/yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("M/dd/yyyy  hh:mm:ss");
        System.out.println(sdf.format(d));
        System.out.println(sdf1.format(d));
        System.out.println(d.toString());
    }
}
