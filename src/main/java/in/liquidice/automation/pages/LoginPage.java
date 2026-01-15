package in.liquidice.automation.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	WebDriverWait wait;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	private By usernameInput = By.id("j_username");
	private By passwordInput = By.id("j_accesscode");
	private By loginButton = By.xpath("//button[@class='btn btn-primary btn-block']");
	public By errorMessage = By.xpath("//*[@class='loginwarningred']"); // For invalid login
	private By logoutButton = By.xpath("//*[contains(text(),'power_settings_new')]");

	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void clickLogoutButton() {
		wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
	}

}
