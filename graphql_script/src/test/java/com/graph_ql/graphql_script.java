package com.graph_ql;

import static io.restassured.RestAssured.given;

import org.junit.Assert;

import io.restassured.path.json.JsonPath;

public class graphql_script {
    
    public static void main(String[] args) {
        
        String response = given().log().all().header("Content-Type","application/json")
       // .body("{\"query\":\"query($episodeId: Int!, $characterId: Int!, $locationId: Int!) \n { \n  \n    episode(episodeId: $episodeId) \n  {\n    name\n  \tepisode\n  }\n  \n  \tcharacters(filters: {name :\"Siya\"})\n      {\n        info\n        {\n          count\n        }\n      }\n  character(characterId: $characterId)\n  {\n    name\n    species\n    type \n  }\n  location(locationId: $locationId)\n  {\n    name\n    type\n    dimension\n  }\n  \t\n}\n\",\"\"variables\":{\"characterId\":5242,\"episodeId\":4258,\"locationId\":5802}\"}")
        .body("query\t\"query IntrospectionQuery {\\n" + //
                " __schema {\\n" + //
                " queryType {\\n" + //
                " name\\n" + //
                " }\\n" + //
                " mutationType {\\n" + //
                " name\\n" + //
                " }\\n" + //
                " subscriptionType {\\n" + //
                " name\\n" + //
                " }\\n" + //
                " types {\\n" + //
                " ...FullType\\n" + //
                " }\\n" + //
                " directives {\\n" + //
                " name\\n" + //
                " description\\n" + //
                " locations\\n" + //
                " args {\\n" + //
                " ...InputValue\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                "}\\n" + //
                "\\n" + //
                "fragment FullType on __Type {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " description\\n" + //
                " fields(includeDeprecated: true) {\\n" + //
                " name\\n" + //
                " description\\n" + //
                " args {\\n" + //
                " ...InputValue\\n" + //
                " }\\n" + //
                " type {\\n" + //
                " …ypeRef\\n" + //
                " }\\n" + //
                " defaultValue\\n" + //
                "}\\n" + //
                "\\n" + //
                "fragment TypeRef on __Type {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " ofType {\\n" + //
                " kind\\n" + //
                " name\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                " }\\n" + //
                "}\\n" + //
                "\"")
        .when().post("http://localhost:5000/graphql")
        .then().extract().response().asString();
        System.out.println(response);
        JsonPath js = new JsonPath(response);
        String name = js.getString("data.getStudents.students.name");
        Assert.assertEquals(name, "Ajay Kumar");
    }
}
