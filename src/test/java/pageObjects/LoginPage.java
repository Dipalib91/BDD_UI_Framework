package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;

import initializePageObject.PageFactoryInitializer;
import utils.Element;
import utils.ExplicitWaiting;

public class LoginPage extends PageFactoryInitializer {
	private By signInLnk = By.xpath("//a[text()='Sign In']");
	private By userNameTxtField = By.name("username");
	private By passwordTxtField = By.name("password");
	private By loginBtn = By.xpath("//button[@type='submit']");
	// private By myAccountLnk = By.xpath("//a[text()='My Account']");
	private By dashboardLnk = By.xpath("//span[@class='oxd-topbar-header-breadcrumb']/h6");

	/**
	 * This method used to enter username and password
	 * 
	 * @param userName
	 * @param password
	 */
	public void loginToApplication(String userName, String password) {

		element.clearEnterText(userNameTxtField, userName, "User Name");
		element.clearEnterText(passwordTxtField, password, "Password");

	}

	/**
	 * This method used to click on login button
	 */
	public void clickOnLogin() {
		element.clickUsingBy(loginBtn, "Login Button");
	}

	/**
	 * This method is used to verify user is successfully logged in or not
	 */
	public void verifyLogin() {
		Assert.assertTrue("Login successfully", element.isVisibleUsingBy(dashboardLnk, "Dashboard Link"));
	}
}
