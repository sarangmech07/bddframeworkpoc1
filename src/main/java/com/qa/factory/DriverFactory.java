package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
	
	
	
	
	/**
	 * This method is used to initialize the threadlocal driver on the basis of the given browser
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser)
	{
		System.out.println("Browser value is :"+ browser);
		
		
		if (browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tlDriver.set(new ChromeDriver());
			System.out.println("Chrome Browser is set");
		}
		else if (browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tlDriver.set(new FirefoxDriver());
			System.out.println("Firefox Browser is set");
		}
		else
		{
			System.out.println("Please pass the correct browser value:"+browser);
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		System.out.println(getDriver());
		return getDriver();
	}
	
	
	/**
	 * This method is to sysnchromized the webdriver
	 * @return
	 */
	public static synchronized WebDriver getDriver()
	{
		return tlDriver.get();
	}

}
