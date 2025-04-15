package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditArticePage {

	@FindBy(xpath="(//a[contains(text(),'Edit Article')])[1]")
	WebElement editArtickeLnk;

	@FindBy(name = "title")
	WebElement articleTitle;

	@FindBy(xpath =  "//input[@name = 'description']")
	WebElement articleDesc;

	@FindBy(name = "body")
	WebElement articleBody;

	@FindBy(name = "tags")
	WebElement articleTags;

	@FindBy(css = "button.btn.btn-lg.pull-xs-right.btn-primary")
	WebElement publishArticleBtn;
	
	@FindBy(xpath = "//div[@class='container']/h1")
	WebElement editedTitle;	

	public EditArticePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	


	public void editArticle(String titleTxt, String descriptionTxt, String bodyTxt, String tagsText)
	{
		editArtickeLnk.click();
		articleTitle.clear();
		articleTitle.sendKeys(titleTxt);
		articleDesc.clear();
		articleDesc.sendKeys(descriptionTxt);
		articleBody.clear();;
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);
		publishArticleBtn.click();
	}
	
	public String verifyArticleTitle() throws InterruptedException {
		Thread.sleep(6000);
		return (editedTitle.getText());
	}

	public String verifyArticleDescription() throws InterruptedException {
		Thread.sleep(6000);
		return (articleDesc.getText());
	}
}
