package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ConfigReader;

public class ApplicationHooks {
	private WebDriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.initProperties();
	}

	@Before(order = 1)
	public void luanchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new WebDriverFactory();
		driver = driverFactory.initDriver(browserName);
	}

	@After(order = 0)
	public void quitBrowser() {
		driver.quit();
	}
	@After(order=1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take screenshot.
			String screenShotName= scenario.getName().replaceAll(" ", "_");
			byte [] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
			driver.quit();
			
		}
	}
}
