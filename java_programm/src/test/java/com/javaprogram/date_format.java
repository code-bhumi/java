package com.javaprogram;

import java.text.SimpleDateFormat;
import java.util.Date;

public class date_format {
    
    public static void main(String[] args) {

        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String date = simpleDateFormat.format(new Date());
        System.out.println(date);
    }
}
