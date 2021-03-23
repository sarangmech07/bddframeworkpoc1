package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty",
						"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
						"timeline:test-output-thread/"},
		features = {"src/test/resources/AppFeatures"},
		glue = {"stepdefinitions", "AppHooks"}
		,
		tags = "@smoke"
		)

public class MyTestRunner {

}
