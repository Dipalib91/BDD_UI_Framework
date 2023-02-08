package utils;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.WebDriverFactory;
import initializePageObject.PageFactoryInitializer;

public class Element {
	static int waitInSeconds = 15;
	public WebDriverFactory factory = new WebDriverFactory();
	public ExplicitWaiting wait = new ExplicitWaiting();

	/**
	 * This method used to click on specific by element
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clickUsingBy(By element, String elementName) {
		try {
			wait.explicitWaitElementToBeClickable(element, waitInSeconds);
			factory.getDriver().findElement(element).click();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method used to click on specific webelement
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clickUsingWebElement(WebElement element, String elementName) {
		try {
			wait.explicitWaitElementToBeClickable(element, waitInSeconds);
			element.click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method is for click on element from list
	 * 
	 * @param element
	 * @param elementName
	 * @param index
	 */
	public void clickFromList(By element, String elementName, int index) {
		try {
			wait.explicitWaitElementToBeClickable(element, waitInSeconds);
			factory.getDriver().findElements(element).get(index).click();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method verify element visible using by
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	public boolean isVisibleUsingBy(By element, String elementName) {
		try {

			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (factory.getDriver().findElement(element).isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * This method verify visibility of webelement
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	public boolean isVisibleUsingWebElement(WebElement element, String elementName) {
		try {

			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (element.isDisplayed()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * This method verify element is not visible
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	public boolean isNotVisible(By element, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(element, 3);
			if ((factory.getDriver().findElement(element).isDisplayed())) {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return true;
		}
		return true;
	}

	/**
	 * This method verify list of element is visible
	 * 
	 * @param e
	 * @param elementName
	 * @return
	 */
	public boolean isListVisibleUsingBy(By e, String elementName) {
		try {
			WebDriverWait wait1 = new WebDriverWait(factory.getDriver(), Duration.ofSeconds(waitInSeconds));
			wait1.until(ExpectedConditions.visibilityOfAllElements(getElementList(e)));
			if (wait.explicitWaitVisibilityOfElements(getElementList(e), waitInSeconds)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * This method verify list of webelements is visible
	 * 
	 * @param e
	 * @param elementName
	 * @return
	 */
	public boolean isListVisibleUsingWebelement(List<WebElement> e, String elementName) {
		try {
			WebDriverWait wait1 = new WebDriverWait(factory.getDriver(), Duration.ofSeconds(waitInSeconds));
			wait1.until(ExpectedConditions.visibilityOfAllElements(e));
			if (wait.explicitWaitVisibilityOfElements(e, waitInSeconds)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	/**
	 * This method return web element
	 * 
	 * @param element
	 * @return
	 */
	public WebElement getElement(By element) {
		WebElement webElement = null;
		try {
			webElement = factory.getDriver().findElement(element);
			return webElement;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return webElement;
	}

	/**
	 * This method return list of webelement
	 * 
	 * @param element
	 * @return
	 */
	public List<WebElement> getElementList(By element) {
		List<WebElement> elementList = null;
		try {
			elementList = factory.getDriver().findElements(element);
			return elementList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementList;
	}

	/**
	 * This method return text from element
	 * 
	 * @param element
	 * @return
	 */
	public String getText(By element) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			return factory.getDriver().findElement(element).getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method return text from webelement
	 * 
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			return element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method return value of the attribute
	 * 
	 * @param element
	 * @return
	 */
	public String getAttributeValue(By element) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			return factory.getDriver().findElement(element).getAttribute("value").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method return type of element
	 * 
	 * @param element
	 * @return
	 */
	public String getAttributeType(By element) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			return factory.getDriver().findElement(element).getAttribute("type").trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * This method clear all the text
	 * 
	 * @param element
	 * @param elementName
	 */
	public void clearTextKeys(By element, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (getElement(element).isEnabled()) {
				getElement(element).sendKeys(Keys.chord(Keys.CONTROL, "a"));
				getElement(element).sendKeys(Keys.BACK_SPACE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to clear and enter the text
	 * 
	 * @param element
	 * @param text
	 * @param elementName
	 */
	public void clearEnterText(By element, String text, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (factory.getDriver().findElement(element).isEnabled()) {
				clearTextKeys(element, elementName);
				getElement(element).sendKeys(text.trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to enter the text
	 * 
	 * @param element
	 * @param text
	 * @param elementName
	 */
	public void enterText(By element, String text, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(getElement(element), waitInSeconds);
			getElement(element).sendKeys(text);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method used to enter the key
	 * 
	 * @param element
	 * @param key
	 * @param elementName
	 */
	public void enterText(By element, Keys key, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (getElement(element).isEnabled()) {
				getElement(element).sendKeys(key);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method check element is enable or not within given time
	 * 
	 * @param element
	 * @param elementName
	 * @param waitTime
	 * @return
	 */
	public boolean isEnable(By element, String elementName, int waitTime) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitTime);
			if (getElement(element).isEnabled()) {
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	/**
	 * This method used to check element is enabled or not
	 * 
	 * @param element
	 * @param elementName
	 * @return
	 */
	public boolean isEnable(By element, String elementName) {
		try {
			wait.explicitWaitVisibilityOfElement(element, waitInSeconds);
			if (getElement(element).isEnabled()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return false;
	}

	/**
	 * This method used to accept the browser alert
	 */
	public void acceptAlert() {
		try {
			Alert simpleAlert = factory.getDriver().switchTo().alert();
			simpleAlert.accept();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * This method is used to cancel the browser alert
	 */
	public void cancelAlert() {
		try {
			Alert simpleAlert = factory.getDriver().switchTo().alert();
			simpleAlert.dismiss();
			;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public String getTextFromAlert() {
		try {
			Alert simpleAlert = factory.getDriver().switchTo().alert();
			return simpleAlert.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void sendKeyToAlert(String text) {
		try {
			Alert simpleAlert = factory.getDriver().switchTo().alert();
			simpleAlert.sendKeys(text);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void verticalPageScroll() {
		JavascriptExecutor js = (JavascriptExecutor) factory.getDriver();
		js.executeScript("window.scrollBy(0,400)", "");
	}
	public void pageScrollAtBottom() {
		JavascriptExecutor js = (JavascriptExecutor) factory.getDriver();
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
}
