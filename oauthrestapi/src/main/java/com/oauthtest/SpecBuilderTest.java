package com.oauthtest;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;

public class SpecBuilderTest {
    
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

        ResponseSpecification resSpec =  new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "qaclick123").
        setContentType(ContentType.JSON).build();
        pl.setLocation(null);
        RequestSpecification res = given().spec(req).body(pl);
        Response response = res.when().post("/maps/api/place/add/json")
        .then().spec(resSpec).extract().response();

        String responseString = response.asString();
        System.out.println(responseString);
        
    }
}
