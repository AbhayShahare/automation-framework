package in.liquidice.automation.hooks;

import in.liquidice.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() {
		DriverManager.getDriver(); // Open Chrome before scenario
	}

	@After
	public void tearDown() {
		DriverManager.quitDriver(); // Close Chrome after scenario
	}
}
