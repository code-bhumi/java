package com.rest_assured.Files;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class DynaminJson {
    
    @Test(dataProvider="BooksData")
    public void Addbook(String isbn, String aisle)

    {
        RestAssured.baseURI = "http://216.10.245.166";
        String response = given().log().all().header("Content-Type", "application/json")
        .body(payload.Addbook(isbn,aisle)).when().post("/Library/Addbook.php")
        .then().log().all().assertThat().statusCode(200)
        .extract().response().asString();
        JsonPath js = ReusableMethod.rawtoJson(response);
        String id = js.get("ID");
        System.out.println(id);

    }

    @DataProvider(name = "BooksData")
    public Object[][] getData()
    {
        // array = collection of elements
        // multidimensional array = collection of arrayS

       return new Object[][] {{"ramayan", "3456"},{"gita", "6754"},{"krishna lila", "3425"}};


    }
}
