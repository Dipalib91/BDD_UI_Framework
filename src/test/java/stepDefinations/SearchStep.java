package stepDefinations;

import initializePageObject.PageFactoryInitializer;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchStep extends PageFactoryInitializer {
	@When("^User clicks on products button$")
	public void user_clicks_on_products_button() {
	   searchPage().clickOnProductsLnk();
	}

	@Then("^User is navigated to all products page$")
	public void user_is_navigated_to_all_products_page() {
	   searchPage().verifyAllProducts();
	}

	@When("^User enter ([^\"]*) in search input$")
	public void user_enter_in_search_input(String productName) {
	    searchPage().searchProduct(productName);
	}

	@When("^User clicks on search button$")
	public void user_clicks_on_search_button() {
	  searchPage().clickOnSearchBtn();
	}

	@Then("^Searched Products is visible$")
	public void searched_products_is_visible() {
	  searchPage().verifySearchedProducts();
	}

	@Then("^All products related to search are visible$")
	public void all_products_related_to_search_are_visible() {
		searchPage().verifyProducts();
	}
}
