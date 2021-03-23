package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.factory.DriverFactory;
import com.qa.util.configReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import parallelRun.parallelRunner;

public class ApplicationHooks {
	
	private DriverFactory driverfactory;
	private WebDriver driver;
	private configReader configreader;
	Properties prop;
	private parallelRunner parallel;
	
	@Before(order=0)
	public void getProperty()
	{
		configreader = new configReader();
		prop = configreader.init_Prop();
	}
	
	@Before(order=1)
	public void launchBrowser() {
//		String browserName = prop.getProperty("browser");
		parallel = new parallelRunner();
		String browser = parallel.browserName;
		driverfactory = new DriverFactory();
		driver = driverfactory.init_driver(browser);
		
	}
	
	@After(order=0)
	public void quitBrowser()
	{
		driver.quit();
	}
	
	@After(order=1)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			
		}
	}
}
