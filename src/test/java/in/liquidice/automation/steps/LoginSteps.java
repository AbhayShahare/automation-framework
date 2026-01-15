package in.liquidice.automation.steps;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import in.liquidice.automation.pages.LoginPage;
import in.liquidice.automation.utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	WebDriver driver = DriverManager.getDriver();
	LoginPage loginPage = new LoginPage(driver);

	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		// Navigate to your login page URL
		driver.get("http:localhost:8080/liquidice");
	}

	@When("the user enters username {string} and password {string}")
	public void the_user_enters_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("clicks the login button")
	public void clicks_the_login_button() {
		loginPage.clickLogin();
	}

	@Then("the user should login successfully")
	public void the_user_should_login_successfylly() {
		// Simple check for successful login
		String expectedUrl = "http://localhost:8080/liquidice/";
		Assert.assertEquals(driver.getCurrentUrl(), expectedUrl, "Dashboard URL did not match");
	}

	@Then("the user should logout from application")
	public void the_user_should_logout_from_application() {
		// Simple logout
		loginPage.clickLogoutButton();
		DriverManager.quitDriver();
	}

	@Then("the user should see an error message {string}")
	public void the_user_should_see_an_error_message(String expectedMessage) {
		// Check for error message (update locator in LoginPage if needed)
		String actualMessage = driver.findElement(loginPage.errorMessage).getText();
		Assert.assertEquals(actualMessage, expectedMessage, "Invalid user id or passwordnam");
		DriverManager.quitDriver();
	}
}
