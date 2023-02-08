package stepDefinations;

import initializePageObject.PageFactoryInitializer;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsStep extends PageFactoryInitializer {

	@Given("^User navigates to the home page$")
	public void user_navigates_to_the_home_page() {
		getDriver().get("https://automationexercise.com/");

	}

	@When("^User clicks on the contact us button$")
	public void user_clicks_on_the_contact_us_button() {
		contactUsPage().clickOnContactUs();
	}

	@Then("^Contact Us form get opened$")
	public void contact_us_form_get_opened() {
		contactUsPage().verifyContactUsForm();
	}

	@When("^User enters contact us details ([^\"]*), ([^\"]*), ([^\"]*) and ([^\"]*)$")
	public void user_enters_contact_us_details_and(String name, String emailId, String subject, String message) {
		contactUsPage().addContactDetails(name, emailId, subject, message);
	}

	@When("^User clicks on submit button$")
	public void user_clicks_on_submit_button() {
		contactUsPage().clickOnSubmit();
	}

	@When("^User clicks on ok button$")
	public void user_clicks_on_ok_button() {
		element.acceptAlert();
	}

	@Then("^Details have been submitted successfully$")
	public void details_have_been_submitted_successfully() {

	}
}
