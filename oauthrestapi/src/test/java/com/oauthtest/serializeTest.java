package com.oauthtest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import io.restassured.response.Response;
import pojo.AddPlace;
import pojo.Location;

public class serializeTest {
    
    public static void main (String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        AddPlace pl = new AddPlace();
        pl.setAccuracy(50);
        pl.setAddress("29, side layout, cohen 09");
        pl.setLanguage("French-IN");
        pl.setName("Frontline House");
        pl.setPhone_number("(+91) 983 893 3937");
        pl.setWebsite("https://rahulshettyacademy.com");
        List<String> myList = new ArrayList<String>();
        myList.add("shop");
        myList.add("shoe park");
        pl.setTypes(myList);

        Location l = new Location();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        pl.setLocation(null);
        Response res = given().log().all().queryParam("key", "qaclick123")
        .body(pl)
        .when().post("/maps/api/place/add/json")
        .then().assertThat().statusCode(200).extract().response();

        String responseString = res.asString();
        System.out.println(responseString);
        
    }
}
