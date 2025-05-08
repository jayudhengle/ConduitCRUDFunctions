package base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;


public class TestBase {
	private static TestBase testBase;
	private static WebDriver driver;
	FirefoxOptions options;

	private TestBase() throws IOException 
	{
		
		System.out.println(System.getProperty("user.dir"));
		String filePath = Paths.get(System.getProperty("user.dir"), "src", "test", "resources", "Properties", "myData.properties").toString();
		FileInputStream fis = new FileInputStream(filePath);

		Properties prop = new Properties();
		prop.load(fis);
		String browser = prop.getProperty("browser");
		System.out.println(browser);
			
		switch(browser)	
		{
			case "firefox":
				driver = new FirefoxDriver();
				break;
				
			case "chrome":
				driver = new ChromeDriver();
				break;
				
			case "edge":
				driver = new EdgeDriver();
				break;

				
			default :					
				options = new FirefoxOptions();
		        URL hubURL = new URL("http://localhost:4444/");
		        driver = new RemoteWebDriver(hubURL, options);			
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().deleteAllCookies();
	}
	

	public static void initDriver() throws IOException {
		if (testBase == null) {
			testBase = new TestBase();
		}
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void openURL(String url) {
		driver.get(url);
	}

	public static void tearDown() {
		if (driver != null) {
			driver.close();
			driver.quit();
		}
		testBase = null;
	}
}
