package com.bdd.StepDefinations;

import com.bdd.Resources.API_Resources;
import com.bdd.Resources.TestDataBuild;
import com.bdd.Resources.Utils;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;
import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils{
   
RequestSpecification res; 
ResponseSpecification resSpec;  
Response response;
TestDataBuild data = new TestDataBuild(); 
static String place_id; 


@Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String name, String language, String address) throws IOException  {
    res = given().spec(requestSpecification())
    .body(data.addPlacePayLoad(name,language,address));
}

@When("user calls {string} with {string} http request")
public void user_calls_with_http_request(String resource, String method) {
   
    API_Resources resourceAPI = API_Resources.valueOf(resource);
    System.out.println(resourceAPI.getResource());

    resSpec =  new ResponseSpecBuilder().expectStatusCode(200)
    .expectContentType(ContentType.JSON).build();
    //then().spec(resSpec).extract().response();
    
    if(method.equalsIgnoreCase("POST"))
    response = res.when().post(resourceAPI.getResource());
    else if(method.equalsIgnoreCase("GET"))  
    response = res.when().get(resourceAPI.getResource());
    
}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
    assertEquals(response.getStatusCode(),200);
    
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String Expectedvalue) {
   
    assertEquals(getJsonPath(response,keyValue),Expectedvalue);

}

@Then("verify place_Id created maps to {string} using {string}")
public void verify_place_id_created_maps_to_using(String expectedName, String resource) throws IOException {
    
    place_id = getJsonPath(response,"place_id");
    res = given().spec(requestSpecification()).queryParam("place_id", place_id);
    user_calls_with_http_request(resource, "GET");
    String actualName = getJsonPath(response, "name");
    assertEquals(actualName, expectedName);

}

@Given("DeletePlace Payload")
public void delete_place_payload() throws IOException {
    
   res = given().spec(requestSpecification()).body(data.deletePlacePayload(place_id));
}

}