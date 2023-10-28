package com.sql.learn;

import com.sql.learn.School;

public class SQLTest {
    public static void main(String[] args) {
        School school = new School();
        school.List();

        school.Insert(4,"Rakesh Kumar", 85, 75, 99, 90, 80);
        school.List();

        //school.Modify(3, "Kishore Kumar");
    }
}
