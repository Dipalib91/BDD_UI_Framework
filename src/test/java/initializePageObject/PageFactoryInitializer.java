package initializePageObject;

import org.openqa.selenium.support.PageFactory;

import factory.WebDriverFactory;
import pageObjects.ContactUsPage;
import pageObjects.EmployeePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import utils.Element;
import utils.ExplicitWaiting;

public class PageFactoryInitializer extends WebDriverFactory {

	public Element element = new Element();
	public ExplicitWaiting wait = new ExplicitWaiting();

	public LoginPage loginPage() {
		return PageFactory.initElements(getDriver(), LoginPage.class);
	}

	public EmployeePage employeePage() {
		return PageFactory.initElements(getDriver(), EmployeePage.class);
	}

	public ContactUsPage contactUsPage() {
		return PageFactory.initElements(getDriver(), ContactUsPage.class);
	}

	public SearchPage searchPage() {
		return PageFactory.initElements(getDriver(), SearchPage.class);
	}
}
