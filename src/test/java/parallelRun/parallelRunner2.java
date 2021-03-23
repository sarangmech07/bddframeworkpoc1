package parallelRun;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"timeline:test-output-thread/",
		"rerun:target/failedrerun.txt"}, 
				features = {"@target/failedrerun.txt" }, 
				glue = { "stepdefinitions", "AppHooks" }, 
				tags = "@smoke")


public class parallelRunner2 extends AbstractTestNGCucumberTests {

	
	public String browserName = "firefox";

	@Override
	@DataProvider(parallel = true)
	public Object[][] scenarios() {
		return super.scenarios();
	}
	
	
}
