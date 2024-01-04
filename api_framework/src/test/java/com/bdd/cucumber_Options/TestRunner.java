package com.bdd.cucumber_Options;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
    stepNotifications = true,
    features="src/test/java/com/bdd/Features", 
    glue = {"com.bdd.StepDefinations"})

public class TestRunner {
   
}
