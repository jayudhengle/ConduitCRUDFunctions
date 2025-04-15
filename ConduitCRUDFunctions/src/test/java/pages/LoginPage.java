package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	@FindBy(name="email")
	WebElement eMail;

	@FindBy(name="password")
	WebElement password;

	@FindBy(css =  "button.btn.btn-lg.btn-primary.pull-xs-right")
	WebElement loginBtn;
	
	@FindBy(xpath = "//button[text() = 'Your Feed']")
	WebElement afterLogin;


	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


	public void logIntoTheApp(String strEmail, String strPassword)
	{
		eMail.sendKeys(strEmail);
		password.sendKeys(strPassword);
		loginBtn.click();
	}
	
	public boolean verifyLoginPage()
	{
		if (afterLogin.isDisplayed())
			return true;
		else
			return false;
	}
}
