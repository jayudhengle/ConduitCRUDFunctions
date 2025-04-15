package stepDefs;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteArticePage;
import pages.EditArticePage;
import pages.LoginPage;
import pages.NewArticelTest;
import pages.ViewArticelTest;

public class ConduitCRUDFunctionsStepDef {

	WebDriver driver = TestBase.getDriver();
	LoginPage loginPage;
	NewArticelTest newArticle;
	ViewArticelTest viewArticle;
	EditArticePage editArticle;
	DeleteArticePage deleteArticle;

	public ConduitCRUDFunctionsStepDef() {
		loginPage = new LoginPage(driver);
		newArticle = new NewArticelTest(driver);
		viewArticle = new ViewArticelTest(driver);
		editArticle = new EditArticePage(driver);
		deleteArticle = new DeleteArticePage(driver);
	}

	@Given("User is on Login page")
	public void user_is_on_login_page() {
		TestBase.openURL("https://conduit-realworld-example-app.fly.dev/#/login");
	}

	@When("User provide {string} and {string}")
	public void user_provide_and(String username, String password) {
		loginPage.logIntoTheApp(username, password);
	}

	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(loginPage.verifyLoginPage());
	}

	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		newArticle.clickNewArticleLink();
	}

	@When("User enters Article details")
	public void user_enters_article_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
		newArticle.enterArticleDetails("12Test46", "12Test2", "1212Test3", "12Test4");
	}

	@Then("Article must be created")
	public void article_must_be_created() throws InterruptedException {
		Assert.assertTrue(viewArticle.verifyArticleTitle());
		Assert.assertTrue(viewArticle.verifyArticleDescription());
	}

	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() {
		viewArticle.navigatetoGlobalFeed();
	}

	@When("User select an article {string}")
	public void user_select_an_article(String articleName) {
		viewArticle.getArticleDetails(articleName);
	}

//	@Then("Article detail page must be displayed")
//	public void article_detail_page_must_be_displayed() {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new io.cucumber.java.PendingException();
//	}

	@Given("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() throws InterruptedException {
		Thread.sleep(3000);
		Assert.assertTrue(viewArticle.verifyArticleTitle());
		Assert.assertTrue(viewArticle.verifyArticleDescription());
	}

	@When("User update article detail")
	public void user_update_article_detail() {
		editArticle.editArticle("12Test47", "12Test2", "1212Test3", "12Test4");
	}

	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() throws InterruptedException {
		Assert.assertTrue(editArticle.verifyArticleDescription());
		Assert.assertTrue(editArticle.verifyArticleTitle());
		Thread.sleep(3000);
	}

	@When("User delete article")
	public void user_delete_article() {
		deleteArticle.deletetheArticle();
	}

	@Then("Article {string} must be deleted")
	public void article_must_be_deleted(String article) throws InterruptedException {
		deleteArticle.verifyDelete(article);
	}

}
