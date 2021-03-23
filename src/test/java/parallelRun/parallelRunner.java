package parallelRun;


import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt"}, 
				features = {"src/test/resources/AppFeatures" }, 
				glue = { "stepdefinitions", "AppHooks" }, 
				tags = "@smoke")

public class parallelRunner extends AbstractTestNGCucumberTests {
	

	public String browserName = "chrome";

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}



}
