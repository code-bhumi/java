package com.rest_assured;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;

import static io.restassured.RestAssured.*;

import java.io.File;

public class JiraPackage {
    
    public static void main(String[] args) {

    RestAssured.baseURI = "http://localhost:8080/";
    // login scenarion
    SessionFilter session = new SessionFilter();
    String response = given().header("Content-Type","application/json")
    .body("{ \r\n"+ "\"username\": \"meenakshi\",  \r\n"+
                  " \"password\": \"adwita\" }").log().all()

    .filter(session).when().post("/rest/auth/1/session")
    .then().log().all().extract().response().asString();

    given().pathParam("id", "10300").log().all()
    .header("Content-Type","application/json")
    .body("{\r\n" +
      "  \"body\": \"This is my first comment\", \r\n" +
      "  \"visibility\": {\r\n" +
      "     \"type\": \"role\", \r\n" +
      "      \"value\": \"Administrators\"\r\n" +
      "     }\r\n" +
      "}")
    .filter(session).when().post("/rest/api/2/issue/{id}/comment")
    .then().log().all().assertThat().statusCode(201);

    // Add Attachment
    given().header("X-Atlassian-Token","no-check")
    .filter(session).pathParam("id", "10300")
    .header("Content-Type", "multipart/form-data")
    .multiPart("file",new File("jira.txt"))
    .when().post("rest/api/2/issue/{id}/attachments")
    .then().log().all().assertThat().statusCode(200);
    

    } 
    
}
