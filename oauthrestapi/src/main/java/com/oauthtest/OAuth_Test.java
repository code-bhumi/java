package com.oauthtest;

import static io.restassured.RestAssured.given;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.GetCourse;
public class OAuth_Test {
    
    public static void main(String[] args) throws InterruptedException {

        // WebDriver driver = new FirefoxDriver();
        // driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
        // driver.findElement(By.cssSelector("input[type='email']")).sendKeys("0325minaxi");
        // driver.findElement(By.cssSelector("input[type'email']")).sendKeys(Keys.ENTER);
        // Thread.sleep(4000);
        // driver.findElement(By.cssSelector("input[type='password']")).sendKeys("gano@baby");
        // driver.findElement(By.cssSelector("input[type'password']")).sendKeys(Keys.ENTER);
        // Thread.sleep(4000);
        // String url = driver.getCurrentUrl();
       
        String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AfJohXmU1Db2M5CFnNZqjfjr1tyiwl6vzxIS321f5wEnn2lViG7kd_5_0O11GNNykQKOKw&scope=email+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email+openid&authuser=0&prompt=consent";

        String partialcode = url.split("code")[1];
        String code = partialcode.split("&scope")[0];
 
        // tagname[attribute = 'value']

        String accessTokenResponse = given().urlEncodingEnabled(false)

        .queryParams("code", code)
        .queryParams("client_id", 	"692183103107-p0m7ent2hk7…s.googleusercontent.com" )
        .queryParams("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
        .queryParams("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
        .queryParams("grant_type","authorization_code")
        .when().log().all()
        .post("https://www.googleapis.com/oauth2/v4/token").asString();
        JsonPath js = new JsonPath(accessTokenResponse);
        String accessToken = js.getString("access_token");
        


        GetCourse gc =  given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
        .when()
        .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

        System.out.println(gc.getLinkedIn());
         System.out.println(gc.getInstructor());
        //System.out.println(response);

       

    }
}


