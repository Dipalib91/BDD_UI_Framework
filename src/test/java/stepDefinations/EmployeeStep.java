package stepDefinations;

import java.util.List;
import java.util.Map;

import initializePageObject.PageFactoryInitializer;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.Element;

public class EmployeeStep extends PageFactoryInitializer {
	@When("^User clicks on PIM link$")
	public void user_clicks_on_pim_link() {
	    employeePage().navigateToPIM();
	}

	@When("^User clicks on add employee button$")
	public void user_clicks_on_add_employee_button() {
	    employeePage().clickOnAddBtn();
	}

	@When("^User enters employee details$")
	public void user_enters_employee_details(DataTable dataTable) {
	   employeePage().addEmployee(dataTable);
	}

	@Then("^User succefully save employee details$")
	public void user_succefully_save_employee_details() {
	   employeePage().verifyEmployeeAdded();
	}

}
