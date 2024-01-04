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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class stepDefination extends Utils{
   
RequestSpecification res; 
ResponseSpecification resSpec;  
Response response;
TestDataBuild data = new TestDataBuild();

@Given("Add Place Payload with {string} {string} {string}")
public void add_place_payload_with(String name, String language, String address) throws IOException {

        res = given().spec(requestSpecification())
        .body(data.addPlacePayLoad(name,language,address));
}

@When("user calls {string} with Post http request")
public void user_calls_with_post_http_request(String resource) {

        API_Resources resourceAPI = API_Resources.valueOf(resource);
        System.out.println(resourceAPI.getResource());
        resSpec =  new ResponseSpecBuilder().
        expectStatusCode(200).expectContentType(ContentType.JSON).build();
        response = res.when().post("/maps/api/place/add/json")
        .then().spec(resSpec).extract().response();
}

@Then("the API call got success with status code {int}")
public void the_api_call_got_success_with_status_code(Integer int1) {
    assertEquals(response.getStatusCode(),200);
}

@Then("{string} in response body is {string}")
public void in_response_body_is(String keyValue, String Expectedvalue) {
    String resp = response.asString();    
    JsonPath js = new JsonPath(resp);
    assertEquals(js.get(keyValue).toString(),Expectedvalue);


}

}
