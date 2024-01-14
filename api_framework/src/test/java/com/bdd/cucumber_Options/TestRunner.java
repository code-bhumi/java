package com.bdd.cucumber_Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    stepNotifications = true,
    features="src/test/java/com/bdd/PlaceValidations",plugin ="json:target/jsonReports/cucumber-report.json",
    glue = {"com", "bdd"})

public class TestRunner {
   
}
   
// tags= "@DeletePlace"  => this comand is used for running a particular test