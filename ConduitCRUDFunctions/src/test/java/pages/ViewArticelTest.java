package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.TestBase;

public class ViewArticelTest {
	
	
	@FindBy(xpath = "//div[@class='container']//h1")
	WebElement articleTitle;
	
	@FindBy(xpath = "//a[text() = 'Home']")
	WebElement homePageLink;
	
	@FindBy(xpath = "//button[text() = 'Global Feed']")
	WebElement globalLink;	


	@FindBy(xpath = "//div[@class='col-md-12']/p")
	WebElement articleDetails;
	
	@FindBy(xpath = "//a[@class='preview-link']/h1")
	WebElement articleName;
	
	public WebElement getElement(String name)
	{
		String xpath = String.format("//*[text()='%s']", name);
		return TestBase.getDriver().findElement(By.xpath(xpath));
	}


	public ViewArticelTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public boolean verifyArticleTitle() {
		return (articleTitle.isDisplayed());
	}

	public boolean verifyArticleDescription() {
		return (articleDetails.isDisplayed());
	}
	
	public void navigatetoGlobalFeed() {
		homePageLink.click();
		globalLink.click();
	}
	
	public void getArticleDetails(String name) {
		getElement(name).click();
	}

}
