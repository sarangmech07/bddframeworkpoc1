package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	
	//1.By Locators
	private By emailId= By.id("email");
	private By password = By.id("passwd");
	private By signInBtn = By.id("SubmitLogin");
	private By forgotPwdLink = By.linkText("Forgot your password?12");

	
	//2. Constructor of the page class
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	
	//3. Page Actions
	
	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExist() {
		return driver.findElement(forgotPwdLink).isDisplayed();
	}

	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
	}

	public void enterPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}

	public void clickOnLogin() {
		driver.findElement(signInBtn).click();
	}

	
	public AccountsPage doLogin(String un, String pwd) {
		System.out.println("login with: " + un + " and " + pwd);
		driver.findElement(emailId).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(signInBtn).click();
		return new AccountsPage(driver);
	}
	
	
	
	
	
	
	
	
	
	
}
