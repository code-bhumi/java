package com.rest_assured;

import com.rest_assured.Files.payload;

import io.restassured.path.json.JsonPath;

/*
 * This is Jason Parser
 */

public class ComplexJsonParse {
    
    public static void main(String args[]) {

        JsonPath js = new JsonPath(payload.CoursePrice());
        // print no of courses returned by API

        int count = js.getInt("courses.size()");
        System.out.println(count);

        // print purchase amount

        int TotalAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(TotalAmount);

        // Print title of the first and last course

        String titleFirstCourse = js.get("courses[0].title");
        System.out.println(titleFirstCourse);

        String TitlelastCourse = js.get("courses[2].title");
        System.out.println(TitlelastCourse);

        // print all courses and their respective prices

        for(int i=0; i<count; i++)
        {
            String courseTitles = (js.get("courses["+i+"].title"));
            System.out.println(js.get("courses["+i+"].price").toString());
            System.out.println(courseTitles);
        }

        // print no of copies sold by RPA course
        System.out.println("Print no of copies sold by RPA Course");

        for(int i=0; i<count; i++)
        {
            String courseTitles = (js.get("courses["+i+"].title"));
            if(courseTitles.equalsIgnoreCase("RPA"))
            {
                // copies sold
                int copies = js.get("courses["+i+"].copies");
                System.out.println(copies);
                break;
            }
        }
    }
}
