package com.api_framework_latest.cucumber_Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    stepNotifications = true,
    features="src/test/java/com/api_framework_latest/PlaceValidations", 
    glue = {"com", "api_framework_latest"})

public class TestRunner {
   
}
   