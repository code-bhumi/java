package com.rest_assured;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;
import static io.restassured.RestAssured.*;
import java.io.File;

import org.testng.Assert;

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

    System.out.println(response);
    
    String expectedMessage = "Hi How are you?";

    String addCommentResponse =  
    given().pathParam("key", "10500").log().all()
    .header("Content-Type","application/json")
    .body("{\r\n" +
      "  \"body\": \""+expectedMessage+"\", \r\n" +
      "  \"visibility\": {\r\n" +
      "     \"type\": \"role\", \r\n" +
      "      \"value\": \"Administrators\"\r\n" +
      "     }\r\n" +
      "}")
    .filter(session).when().post("/rest/api/2/issue/{key}/comment")
    .then().log().all().assertThat().statusCode(201)
    .extract().response().asString();

    JsonPath js = new JsonPath(addCommentResponse);
    String commentId = js.getString("id");

    // Add Attachment
    given().header("X-Atlassian-Token","no-check")
    .filter(session).pathParam("key", "10500")
    .header("Content-Type", "multipart/form-data")
    .multiPart("file",new File("/Users/meenakshipal/git_hub/java/api_restassured/src/test/java/com/rest_assured/jira.txt"))
    .when().post("rest/api/2/issue/{key}/attachments")
    .then().log().all().assertThat().statusCode(200);
    
    // Get Issue
    String issueDetails = given().filter(session).pathParam("key", "10500")
    .queryParam("fields", "comment")  // by this command we can limit the number of fields present in the json
    .log().all().when().get("rest/api/2/issue/{key}")
    .then().log().all().extract().response().asString();

    System.out.println("--------------------------------------");
    System.out.println(issueDetails);
    System.out.println("--------------------------------------");

    JsonPath js1 = new JsonPath(issueDetails);
    int commentsCount =  js1.getInt("fields.comment.comments.size()");
    for(int i=0; i<commentsCount; i++)
    {
       String commentIdIssue = js1.get("fields.comment.comments["+i+"].id").toString();
       if (commentIdIssue.equalsIgnoreCase(commentId))
       {
           String message = js1.get("fields.comment.comments["+i+"].body").toString();
           System.out.println(message);
           Assert.assertEquals(message, expectedMessage);
          
       }
    }
  } 
    
}
