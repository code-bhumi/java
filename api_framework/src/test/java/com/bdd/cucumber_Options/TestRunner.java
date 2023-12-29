package com.bdd.cucumber_Options;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/com/bdd/Features", glue = {"StepDefinations"})



public class TestRunner {
    
}
