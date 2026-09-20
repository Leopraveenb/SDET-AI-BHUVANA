package com.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

	@CucumberOptions(
	        features = "src\\test\\resources\\Feature\\AdactinHotelApp.feature",
	        glue = "com.stepdefinition")

public class TestRunnerForAdactin {

}
