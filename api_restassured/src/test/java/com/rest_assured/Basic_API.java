package com.rest_assured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import com.rest_assured.Files.payload;

public class Basic_API {
    
    public static void main(String[] args) {

        // Validate if ADD place API is working as expected or not

        // give - All input details
        // when - Submit the API, resource , http method
        // then - Validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        given().log().all().queryParam("key", "qaclick123").header("Content-Type", "application/json")
        .body(payload.AddPlace()).when().post("maps/api/place/add/json")
        .then().log().all().assertThat().statusCode(200);
    }
}
