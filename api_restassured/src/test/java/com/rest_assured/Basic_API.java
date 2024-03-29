package com.rest_assured;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;
import org.testng.Assert;
import static io.restassured.RestAssured.*;
import com.rest_assured.Files.ReusableMethod;
import com.rest_assured.Files.payload;

public class Basic_API {
    
    public static void main(String[] args) {

        // Validate if ADD place API is working as expected or not

        // give - All input details
        // when - Submit the API, resource , http method
        // then - Validate the response

        RestAssured.baseURI = "https://rahulshettyacademy.com";
        String response = given().log().all()
        .queryParam("key", "qaclick123")
        .header("Content-Type", "application/json")
        .body(payload.AddPlace()).when().post("maps/api/place/add/json")
        .then().assertThat().statusCode(200).body("scope", equalTo("APP"))
        .header("server", "Apache/2.4.52 (Ubuntu)").extract().response().asString();

        // Add place -> update place with new address -> get place to validate if new address is present in response
        System.out.println(response);
        JsonPath js = new JsonPath(response);  // for parsing json
        String placeId = js.getString("place_id");

        System.out.println(placeId);

        // update place

        String newAddress = "Summer Walk, Australia";

        given().log().all().queryParam("key", "qaclick123")
        .header("Content-Type", "application/json")
        .body("{\r\n" +
            "\"place_id\":\""+placeId+"\",\r\n" +
             "\"address\":\""+newAddress+"\",\r\n" +
             "\"key\":\"qaclick123\"\r\n" +
            "}")
        .when().put("maps/api/place/update/json")
        .then().assertThat().log().all().statusCode(200)
        .body("msg", equalTo("Address successfully updated"));
        
        String getPlaceResponse = given().log().all().queryParam("key", "qaclick123")
        .queryParam("place_id",placeId).when().get("maps/api/place/get/json")
        .then().assertThat().log().all().statusCode(200)
        .extract().response().asString();
        System.out.println("---------------------------------------------------------------");
        System.out.println(getPlaceResponse);
        System.out.println("---------------------------------------------------------------");

        JsonPath js1 = ReusableMethod.rawtoJson(getPlaceResponse);
        String actualAddress = js1.getString("address");
        System.out.println(actualAddress);
        Assert.assertEquals(actualAddress, "Summer Walk, Australia");


    }
}
