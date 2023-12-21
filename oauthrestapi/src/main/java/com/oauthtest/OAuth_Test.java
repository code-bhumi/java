package com.oauthtest;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.testng.Assert;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.API;
import pojo.GetCourse;
import pojo.WebAutomation;
public class OAuth_Test {
    
    public static void main(String[] args) throws InterruptedException {

        String[] courseTitles = {"Selenium Webdriver Java", "Cypress", "Protractor"};
        // WebDriver driver = new FirefoxDriver();
        // driver.get("https://accounts.google.com/o/oauth2/v2/auth?scope=https://www.googleapis.com/auth/userinfo.email&auth_url=https://accounts.google.com/o/oauth2/v2/auth&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&response_type=code&redirect_uri=https://rahulshettyacademy.com/getCourse.php");
        // driver.findElement(By.cssSelector("input[type='email']")).sendKeys("0325minaxi");
        // driver.findElement(By.cssSelector("input[type'email']")).sendKeys(Keys.ENTER);
        // Thread.sleep(4000);
        // driver.findElement(By.cssSelector("input[type='password']")).sendKeys("gano@baby");
        // driver.findElement(By.cssSelector("input[type'password']")).sendKeys(Keys.ENTER);
        // Thread.sleep(4000);
        // String url = driver.getCurrentUrl();
        
        String url = "https://www.googleapis.com/oauth2/v4/token?code=4%2F0AY0e-g6UUD1-sMKIpsxzb520ZVflKe7i8xD_oQk6X3t_fjDqhaROnrJncgGX7dEF0jllVg&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com&client_secret=erZOWM9g3UtwNRj340YYaK_W&redirect_uri=https://rahulshettyacademy.com/getCourse.php&grant_type=authorization_code#";

        String partialcode = url.split("code")[1];
        String code = partialcode.split("&scope")[0];
        System.out.println(code);
 
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
        System.out.println("---------------------------------------------");
        System.out.println(accessTokenResponse);
        System.out.println(accessToken);
        System.out.println("---------------------------------------------");
        


        GetCourse gc =  given().queryParam("access_token", accessToken).expect().defaultParser(Parser.JSON)
        .when()
        .get("https://rahulshettyacademy.com/getCourse.php").as(GetCourse.class);

        System.out.println(gc.getLinkedIn());
        System.out.println(gc.getInstructor());
        System.out.println(gc.getCourses().getApi().get(1).getCourseTitle());

        List<API> apiCourses = gc.getCourses().getApi();
        for(int i=0; i<apiCourses.size(); i++)
        {
            if(apiCourses.get(i).getCourseTitle().equalsIgnoreCase("SoapUI Webservices testing"))
            {
                System.out.println(apiCourses.get(i).getPrice());
            }
        }

        // get the course names of webautomation
        ArrayList<String> a = new ArrayList<String>();
        List<WebAutomation> wa = gc.getCourses().getWebAutomation();
        for(int j=0;j<wa.size();j++)
        {
            a.add(wa.get(j).getCourseTitle());
        }

        List<String> expectedList = Arrays.asList(courseTitles);
        Assert.assertTrue(a.equals(expectedList));

    }
}


