package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {
	
	public WebDriver driver;
	public static ThreadLocal<WebDriver> tldriver= new ThreadLocal<WebDriver>();
	
	public WebDriver initDriver(String browser) {
		System.out.println("Broweser is : "+browser);
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
			setDriver(driver);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver= new FirefoxDriver();
			setDriver(driver);
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver= new EdgeDriver();
			setDriver(driver);
		}
		else if(browser.equalsIgnoreCase("headless")) {
			ChromeOptions option=new ChromeOptions();
			option.addArguments("--headless");
			driver=new ChromeDriver(option);
			setDriver(driver);
		}
		else {
			System.out.println("please pass the correct browser : "+browser);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	public  WebDriver getDriver() {
		return tldriver.get();
	}
	
	public void setDriver(WebDriver driver) {
		tldriver.set(driver);	
	}
}
