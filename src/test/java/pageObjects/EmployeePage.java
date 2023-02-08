package pageObjects;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;

import initializePageObject.PageFactoryInitializer;
import io.cucumber.datatable.DataTable;
import utils.Element;
import utils.ExplicitWaiting;
import utils.RandomGenerator;

public class EmployeePage extends PageFactoryInitializer {
	private By pimLnk = By.xpath("//ul[@class='oxd-main-menu']/li[2]");
	private By addBtn = By.xpath("//div[@class='orangehrm-header-container']/button");
	private By addEmployeeTxt = By.xpath("//h6[text()='Add Employee']");
	private By firstNameTxt = By.xpath("//input[@name='firstName']");
	private By middleNameTxt = By.xpath("//input[@name='middleName']");
	private By lastNameTxt = By.xpath("//input[@name='lastName']");
	private By employeeIdTxt = By.xpath("//div//label[text()='Employee Id']/../following::div/input");
	private By saveBtn = By.xpath("//button[@type='submit']");
	private By successMsg = By.xpath("//div[@class='oxd-toast-start']/div[2]/p");

	/**
	 * This method used to navigate PIM link
	 */
	public void navigateToPIM() {
		if (element.isVisibleUsingBy(pimLnk, "PIM Link")) {
			element.clickUsingBy(pimLnk, "PIM Link");
		}
		Assert.assertTrue("Add Button is not visible", element.isVisibleUsingBy(addBtn, "Add Button"));
	}

	/**
	 * This method used to click on add button
	 */
	public void clickOnAddBtn() {
		if (element.isVisibleUsingBy(addBtn, "Add Button")) {
			element.clickUsingBy(addBtn, "Add Button");
		}
	}

	/**
	 * This method used to add employee details
	 * 
	 * @param empTable
	 */
	public void addEmployee(DataTable empTable) {
		List<Map<String, String>> details = empTable.asMaps(String.class, String.class);
		String fName = details.get(0).get("firstName");
		wait.explicitWaitVisibilityOfElement(firstNameTxt, 10);
		element.enterText(firstNameTxt, fName, "First Name");
		String mName = details.get(0).get("middleName");
		wait.explicitWaitVisibilityOfElement(middleNameTxt, 10);
		element.enterText(middleNameTxt, mName, "Middle Name");
		wait.explicitWaitVisibilityOfElement(lastNameTxt, 10);
		String lName = details.get(0).get("lastName");
		element.enterText(lastNameTxt, lName, "Last Name");
		wait.explicitWaitVisibilityOfElement(employeeIdTxt, 10);
		String empId = RandomGenerator.generateRandomNumber(4);
		element.clearEnterText(employeeIdTxt, empId, "Employee id");
		if (element.isVisibleUsingBy(saveBtn, "Save button")) {
			element.clickUsingBy(saveBtn, "Save Button");
		}
	}

	/**
	 * This method verify employee added successfully
	 */
	public void verifyEmployeeAdded() {
		Assert.assertEquals(element.getText(successMsg), "Success");
	}
}
