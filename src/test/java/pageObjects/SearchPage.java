package pageObjects;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import initializePageObject.PageFactoryInitializer;
import utils.Element;

public class SearchPage extends PageFactoryInitializer {
	static String productName1;
	private By productsLnk = By.xpath("//a/i[@class='material-icons card_travel']");
	private By searchBox = By.id("search_product");
	private By searchBtn = By.id("submit_search");
	private By allProductsTxt = By.xpath("//h2[text()='All Products']");
	private By searchedProductsTxt = By.xpath("//h2[text()='Searched Products']");
	private By productList = By.xpath("//div[@class='productinfo text-center']/p");

	/**
	 * This method used to click on products link
	 */
	public void clickOnProductsLnk() {
		if (element.isVisibleUsingBy(productsLnk, "Products link")) {
			element.clickUsingBy(productsLnk, "Products link");
		}
	}

	/**
	 * This method used to verify all products
	 */
	public void verifyAllProducts() {
		Assert.assertEquals("ALL PRODUCTS", element.getText(allProductsTxt));
	}

	/**
	 * This method used to search product
	 * 
	 * @param productName
	 */
	public void searchProduct(String productName) {
		productName1 = productName;
		if (element.isVisibleUsingBy(searchBox, "Search input box")) {
			element.enterText(searchBox, productName, "search product name");
		}
	}

	/**
	 * This method used to click on search button
	 */
	public void clickOnSearchBtn() {
		if (element.isVisibleUsingBy(searchBtn, "search button")) {
			element.clickUsingBy(searchBtn, "search button");
		}
	}

	/**
	 * This method used to verify searched products
	 */
	public void verifySearchedProducts() {
		Assert.assertEquals("SEARCHED PRODUCTS", element.getText(searchedProductsTxt));
	}

	/**
	 * This method used to verify product names
	 */
	public void verifyProducts() {
		List<WebElement> products = element.getElementList(productList);
		for (WebElement product : products) {
			String tempProduct = element.getText(product);
			System.out.println(tempProduct);
			Assert.assertTrue("product not found", tempProduct.contains(productName1));
		}
	}
}
