package com.testrunner;
//Checks updates
import org.junit.runner.RunWith;
//changes by Dhana

//Cloned by Bhuvana


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

	@CucumberOptions(
	        features = "src\\test\\resources\\Feature\\AdactinHotelApp.feature",
	        glue = "com.stepdefinition")

public class TestRunnerForAdactin {

}
