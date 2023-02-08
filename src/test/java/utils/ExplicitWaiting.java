package utils;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import factory.WebDriverFactory;

public class ExplicitWaiting extends WebDriverFactory {
	/**
     * To Wait Until Element to be Clickable
     */
    public void explicitWaitElementToBeClickable(WebElement element, int Seconds) {
        WebDriverWait clickableWait = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public void explicitWaitElementToBeSelected(WebElement element, int Seconds) {
        WebDriverWait selectableWait = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Element has the text
     */
    public void explicitWaitTextToBePresentInElement(WebElement element, int Seconds, String text) {
        WebDriverWait textToBePresent = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        textToBePresent.until(ExpectedConditions.textToBePresentInElement(element, text));
    }


    /**
     * To Wait Until Title contains the text
     */
    public void explicitWaitTitleContains(WebElement element, int Seconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public void explicitWaitTitleIs(WebElement element, int Seconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public void explicitWaitVisibilityOfElement(WebElement element, int Seconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public void explicitWaitSelectionStateToBe(WebElement element, int Seconds, boolean selected) {
        WebDriverWait elementIsSelected = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        elementIsSelected.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait Until Elements to be Visible
     * @return 
     */
    public  boolean explicitWaitVisibilityOfElements(List<WebElement> element, int Seconds) {
        WebDriverWait elementsToBeVisible = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        elementsToBeVisible.until(ExpectedConditions.visibilityOfAllElements(element));
		return true;
    }
    
    /**
     * To check for element is visible instant
     */
    @SuppressWarnings("deprecation")
	public boolean checkIfElementVisibleInstant(WebDriver driver, WebElement el) {
		boolean flag = false;
		try {
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
			if (el.isDisplayed()) {
				flag = true;
			}
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		} catch (NoSuchElementException e) {
		}
		return flag;
	}
    
    /**
     * Wait for page load completely
     */
    public void waitForPageLoaded(WebDriver driver) {
	      ExpectedCondition<Boolean> expectation = new
	              ExpectedCondition<Boolean>() {
	                  public Boolean apply(WebDriver driver) {
	                      return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	                  }
	              };
	      try {
	          Thread.sleep(1000);
	          @SuppressWarnings("deprecation")
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	          wait.until(expectation);
	      } catch (Throwable error) {
	    	 // Reporter.fail("Timeout waiting for Page Load Request to complete.");
	          Assert.fail("Timeout waiting for Page Load Request to complete.");
	      }
	  }
    
    /**
     * Wait for seconds
     */
    public void waitForSeconds(int timeoutInSeconds) {
		try {
			Thread.sleep(timeoutInSeconds * 1000);
		} catch (InterruptedException e) {
			
		}
	}

    /*Select using By Method*/

    /**
     * To Wait Until Element to be Clickable
     */
    public void explicitWaitElementToBeClickable(By element, int Seconds) {
        WebDriverWait clickableWait = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        clickableWait.until(ExpectedConditions.elementToBeClickable(element));
    }


    /**
     * To Wait Until Element to be Selectable
     */
    public void explicitWaitElementToBeSelected(By element, int Seconds) {
        WebDriverWait selectableWait = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        selectableWait.until(ExpectedConditions.elementToBeSelected(element));
    }


    /**
     * To Wait Until Title contains the text
     */
    public void explicitWaitTitleContains(By element, int Seconds, String title) {
        WebDriverWait titleContains = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        titleContains.until(ExpectedConditions.titleContains(title));
    }


    /**
     * To Wait Until Title is
     */
    public void explicitWaitTitleIs(By element, int Seconds, String title) {
        WebDriverWait titleIs = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        titleIs.until(ExpectedConditions.titleIs(title));
    }


    /**
     * To Wait Until Element to be Visible
     */
    public void explicitWaitVisibilityOfElement(By element, int Seconds) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        elementToBeVisible.until(ExpectedConditions.visibilityOfElementLocated(element));
    }


    /**
     * To Wait Until Element is Selected
     */
    public void explicitWaitSelectionStateToBe(By element, int Seconds, boolean selected) {
        WebDriverWait elementToBeVisible = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        elementToBeVisible.until(ExpectedConditions.elementSelectionStateToBe(element, selected));
    }


    /**
     * To Wait for the Alert
     */
    public void explicitWaitForAlert(int Seconds) {
        WebDriverWait waitForAlert = new WebDriverWait(getDriver(), Duration.ofSeconds(Seconds));
        waitForAlert.until(ExpectedConditions.alertIsPresent());
    }
}
