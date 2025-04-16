package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewArticelTest {

	@FindBy(linkText = "New Article")
	WebElement newArticleLnk;

	@FindBy(name = "title")
	WebElement articleTitle;

	@FindBy(xpath = "//input[@name = 'description']")
	WebElement articleDesc;

	@FindBy(name = "body")
	WebElement articleBody;

	@FindBy(name = "tags")
	WebElement articleTags;

	@FindBy(css = "button.btn.btn-lg.pull-xs-right.btn-primary")
	WebElement publishArticleBtn;

	@FindBy(xpath = "//div[@class='container']//h1")
	WebElement newArticleTitle;

	@FindBy(css = "span.error-messages")
	WebElement articleError;

	public NewArticelTest(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickNewArticleLink() {
		newArticleLnk.click();
	}

	public void enterArticleDetails(String titleTxt, String descriptionTxt, String bodyTxt, String tagsText)
			throws InterruptedException {
		articleTitle.clear();
		articleTitle.sendKeys(titleTxt);
		articleDesc.clear();
		articleDesc.sendKeys(descriptionTxt);
		articleDesc.clear();
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);

		try {
			publishArticleBtn.click();
		} catch (Exception e) {
			System.out.println("Title already exists..");
		}
		Thread.sleep(4000);
	}
	
	public void enterDuplicateArticleDetails(String titleTxt, String descriptionTxt, String bodyTxt, String tagsText)
			throws InterruptedException {
		articleTitle.clear();
		articleTitle.sendKeys(titleTxt);
		articleDesc.clear();
		articleDesc.sendKeys(descriptionTxt);
		articleDesc.clear();
		articleBody.sendKeys(bodyTxt);
		articleTags.sendKeys(tagsText);
		publishArticleBtn.click();
		Thread.sleep(3000);		
	}
	
	
	public String validateDuplicateError()
	{
		return (articleError.getText());
	}

	public String verifyNeArticleTitle() throws InterruptedException {
		Thread.sleep(5000);
		return (newArticleTitle.getText());
	}

}
