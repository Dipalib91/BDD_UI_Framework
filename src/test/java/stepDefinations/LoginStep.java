package stepDefinations;

import factory.WebDriverFactory;
import initializePageObject.PageFactoryInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.ConfigReader;

public class LoginStep extends PageFactoryInitializer {
	@Given("^User navigates to login page$")
	public void user_navigates_to_login_page() throws Exception {
		getDriver().get(ConfigReader.get("url"));
	}
	
	@When("^User enter valid credentials ([^\"]*) and ([^\"]*)$")
	public void user_enter_valid_credentials_and(String userName, String password) {
	    loginPage().loginToApplication(userName, password);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() {
	   loginPage().clickOnLogin();
	}

	@Then("^User successfully logged in$")
	public void user_successfully_logged_in() {
	   loginPage().verifyLogin();
	}
}
