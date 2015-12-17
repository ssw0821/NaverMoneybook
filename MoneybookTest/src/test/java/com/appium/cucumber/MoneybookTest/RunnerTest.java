package com.appium.cucumber.MoneybookTest;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
//		plugin = {"pretty"}, 
		features ={"src/test/resource"},
		format = {"pretty",
				"json:target/cucumber.json",
				"html:target/cucumber-html-report/"}
		
		,tags = {"@Suit01, @Suit02, @Suit03, @Suit04"}
		)

public class RunnerTest {

}
