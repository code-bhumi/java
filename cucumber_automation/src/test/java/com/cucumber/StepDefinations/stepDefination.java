package com.cucumber.StepDefinations;

import org.junit.runner.RunWith;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class stepDefination {  
    @Given("^User is on NetBanking Landing page$")
    public void User_is_on_NetBanking_Landing_page() throws Throwable {
        System.out.println("navigated to login url");
    }
    
    @Then("^Home page is populated$")
    public void Home_page_is_populated()throws Throwable {
        System.out.println("Validated Homepage");
    }

    @When("^User login into Application with \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void User_login_into_Application_with_something_and_password_something(String arg1, String arg2) throws Throwable {
        System.out.println(arg1);
        System.out.println(arg2);
    }

    @Then("^Cards displayed are \"([^\"]*)\"$")
    public void Cards_displayed_are(String arg1) throws Throwable {
        System.out.println(arg1);   
    } 
}
