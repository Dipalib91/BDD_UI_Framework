package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		//tags= "@search",
		features= {"src/test/resources/Features"},
		glue= {"stepDefinations","AppHooks"},
		monochrome = true,
		publish = true,

		plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
	)
public class RunTest {
	
}
