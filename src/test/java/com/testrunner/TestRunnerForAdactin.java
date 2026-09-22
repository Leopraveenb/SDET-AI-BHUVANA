package com.testrunner;

import org.junit.runner.RunWith;
//Cloned by Bhuvana


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
//command by Dhana

	@CucumberOptions(
	        features = "src\\test\\resources\\Feature\\AdactinHotelApp.feature",
	        glue = "com.stepdefinition")

public class TestRunnerForAdactin {

}
