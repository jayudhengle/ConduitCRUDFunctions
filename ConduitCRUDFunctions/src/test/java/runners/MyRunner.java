package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = ".//src//test//resources//features//ConduitCRUDFunctions.feature",
		glue = {"stepDefs"},
		monochrome = true,
		dryRun = false,
		plugin = {"pretty",
				"html:target/Reports/index.html"}			
		)


public class MyRunner extends AbstractTestNGCucumberTests
{
	

}
