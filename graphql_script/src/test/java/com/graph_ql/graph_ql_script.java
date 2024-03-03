package com.graph_ql;

import static io.restassured.RestAssured.*;
import org.junit.Assert;
import io.restassured.path.json.JsonPath;

public class graph_ql_script {
    
    public static void main(String[] args) {

        
        String response = given().log().all().header("Content-Type","application/json")
        .body("{\"query\":\"query($episodeId: Int!, $characterId: Int!, $locationId: Int!) \n { \n  \n    episode(episodeId: $episodeId) \n  {\n    name\n  \tepisode\n  }\n  \n  \tcharacters(filters: {name :\"Siya\"})\n      {\n        info\n        {\n          count\n        }\n      }\n  character(characterId: $characterId)\n  {\n    name\n    species\n    type \n  }\n  location(locationId: $locationId)\n  {\n    name\n    type\n    dimension\n  }\n  \t\n}\n\",\"\"variables\":{\"characterId\":5242,\"episodeId\":4258,\"locationId\":5802}\"}")
        .when().post("https://rahulshettyacademy.com/gq/graphql")
        .then().extract().response().asString();

        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("here is the response");
        System.out.println(response);
        System.out.println("-------------------------------------------------------------------------------");
        JsonPath js = new JsonPath(response);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("here is the json");
        System.out.println(js);
        System.out.println("-------------------------------------------------------------------------------");
        String characterName = js.getString("data.character.name");
        Assert.assertEquals(characterName, "Siya");

        



    }   
}


// \"variables\":{\"characterId\":5172,\"episodeId\":4237,\"locationId\":5773}