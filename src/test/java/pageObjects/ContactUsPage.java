package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import factory.WebDriverFactory;
import initializePageObject.PageFactoryInitializer;
import utils.Element;
import utils.ExplicitWaiting;

public class ContactUsPage extends PageFactoryInitializer {
	//WebDriverFactory factory = new WebDriverFactory();
	
	private By homePageLogo = By.xpath("//div[@class= 'logo pull-left']");
	private By contactUsLnk = By.xpath("//a[text()=' Contact us']");
	private By getInTouchTxt = By.xpath("(//h2[@class= 'title text-center'])[2]");
	private By nameTxt = By.xpath("//input[@placeholder='Name']");
	private By emailTxt = By.xpath("//input[@placeholder='Email']");
	private By subjectTxt = By.xpath("//input[@name='subject']");
	private By messageTxt = By.id("message");
	private By submitBtn = By.xpath("//input[@name='submit']");
	private By successMsg = By.xpath("//div[@class='status alert alert-success']");

	/**
	 * This method used to click on contact us button
	 */
	public void clickOnContactUs() {
		if (element.isVisibleUsingBy(contactUsLnk, "Contact Us Link")) {
			element.clickUsingBy(contactUsLnk, "Contact Us Link");
		}
	}

	/**
	 * This method used to verify contact us form
	 */
	public void verifyContactUsForm() {
		String titleTxt = element.getText(getInTouchTxt);
		Assert.assertEquals("GET IN TOUCH", titleTxt);
	}

	/**
	 * This method used to add contact us details
	 * @param name
	 * @param emailId
	 * @param subject
	 * @param message
	 */
	public void addContactDetails(String name, String emailId, String subject, String message) {
		wait.explicitWaitVisibilityOfElement(nameTxt, 10);
		element.enterText(nameTxt, name, "Name field");
		wait.explicitWaitVisibilityOfElement(emailTxt, 10);
		element.enterText(emailTxt, emailId, "EmailId field");
		wait.explicitWaitVisibilityOfElement(subjectTxt, 10);
		element.enterText(subjectTxt, subject, "Subject field");
		wait.explicitWaitVisibilityOfElement(messageTxt, 10);
		element.enterText(messageTxt, message, "Message field");
	}

	/**
	 * This method is used to click on submit button
	 */
	public void clickOnSubmit() {
		element.verticalPageScroll();
		if (element.isVisibleUsingBy(submitBtn, "Submit Button")) {
			element.clickUsingBy(submitBtn, "Submit Button");
		}
	}

	/**
	 * This method used to handle alert
	 */
	public void handleAlert() {
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}

	/**
	 * This method used to verify contact details get added successfully
	 */
	public void verifyContactDetailsAdded() {
		String actualTxt = element.getText(successMsg);
		Assert.assertEquals("Success! Your details have been submitted successfully.", actualTxt);
	}
}
