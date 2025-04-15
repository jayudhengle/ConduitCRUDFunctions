package pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class DeleteArticePage {

	@FindBy(xpath="(//button[contains(text(),'Delete Article')])[1]")
	WebElement deleteArtickeLnk;
	
	@FindAll(@FindBy(xpath = "//a[@class='preview-link']/h1"))
	List<WebElement> articleCheck;	
	
	@FindBy(xpath="//*[text() = 'Global Feed']")
	WebElement clickGloblaFeed;

	
	
	public DeleteArticePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getElement(String article)
	{
		String xpath = String.format("//*[text()='%s']", article);
		return TestBase.getDriver().findElement(By.xpath(xpath));
	}
	

	public void deletetheArticle()
	{
		deleteArtickeLnk.click();
	    Alert alert = TestBase.getDriver().switchTo().alert();
	    alert.accept();	    
	}
	
	public boolean verifyDelete(String article) throws InterruptedException
	{
		clickGloblaFeed.click();
		Thread.sleep(3000);
		for (WebElement i : articleCheck)
		{
			if(i.getText() != article)
				return true;
			else
				return false;
		}
		return false;
		
		
	}

}
