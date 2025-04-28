package stepDefs;

import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;

public class Hooks 
{
	WebDriver driver;
	
	@BeforeAll
	public static void setUpDriver() throws IOException
	{
		TestBase.initDriver();
	}
	
	@After
	public void takeScreenshot(Scenario scenario) throws MalformedURLException
	{
		driver = TestBase.getDriver();
		if(scenario.isFailed())
		{
			TakesScreenshot scr = (TakesScreenshot)driver;
			byte[] img = scr.getScreenshotAs(OutputType.BYTES);
			scenario.attach(img, "image/png", "FailedScenarioImage");
		}
	}
	
	@AfterAll
	public static void closeBrowser()
	{
		TestBase.tearDown();
	}
}
