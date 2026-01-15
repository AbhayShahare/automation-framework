package in.liquidice.automation.utils;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	private static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().setup();
			// Create ChromeOptions
			ChromeOptions options = new ChromeOptions();

			// Suppress "Chrome is being controlled by automated test software"
			options.setExperimentalOption("excludeSwitches", new String[] { "enable-automation" });
			options.setExperimentalOption("useAutomationExtension", false);
			// Optional: start maximized
			options.addArguments("start-maximized");

			// Optional: disable notifications
			options.addArguments("--disable-notifications");

			options.setExperimentalOption("prefs",
					Map.of("credentials_enable_service", false, "profile.password_manager_enabled", false));

			// Initialize driver with options
			driver = new ChromeDriver(options);

		}
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			try {
				driver.quit(); // Close all browser windows
			} catch (Exception e) {
				System.out.println("Error closing the browser: " + e.getMessage());
			} finally {
				driver = null; // Reset driver to null so next scenario gets a fresh browser
			}
		}
	}

	/**
	 * Optional: Reset browser without quitting the driver completely. Can be used
	 * if you want the same browser instance but a clean page.
	 */
	public static void resetBrowser() {
		if (driver != null) {
			driver.manage().deleteAllCookies(); // Clears cookies
			driver.navigate().to("about:blank"); // Opens blank page
		}
	}

}
