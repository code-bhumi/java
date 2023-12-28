package com.cucumber.CucumberOptions;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

// provide the path of feature file

@RunWith(Cucumber.class)
@CucumberOptions(
    stepNotifications = true,
    features = "src/test/java/com/cucumber/Features",
    glue = "com.cucumber.StepDefinations")

public class TestRunner {  
}  
  