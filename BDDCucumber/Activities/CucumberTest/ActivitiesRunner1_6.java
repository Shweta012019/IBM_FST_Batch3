package CucumberTest;
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "Features",
	    glue = {"stepDefinitions"},
	    tags = "@Activity1_6",
	    plugin= {"pretty"},
	    monochrome=true
	)
public class ActivitiesRunner1_6 {}	

