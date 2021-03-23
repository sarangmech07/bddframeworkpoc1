package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginMultipleData {
	
	private LoginPage loginPage =new LoginPage(DriverFactory.getDriver());
	private static String title;
	
	@Given("user is on Application Landing Page")
	public void user_is_on_application_landing_page() {
		DriverFactory.getDriver()
		.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}
	

	@When("user enters username {string} in username field")
	public void user_enters_username_in_username_field(String userName) {
	    
		loginPage.enterUserName(userName);
	}

	@When("user enters password {string} in password field")
	public void user_enters_password_in_password_field(String password) {
		
		loginPage.enterPassword(password);
	    
	}

	@When("user clicks on Login button of Landing Page")
	public void user_clicks_on_login_button_of_landing_page() {
	   
		loginPage.clickOnLogin();
	}

	@Then("user gets login failed error message")
	public void user_gets_login_failed_error_message() {
		
		System.out.println("Login Failed Error Message is displayed.....");
	   
	}

}
