package in.liquidice.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features", // Path to feature files
		glue = { "in.liquidice.automation.steps", "in.liquidice.automation.hooks" }, // Package containing step
																						// definitions
		plugin = { "pretty", // Console output
				"html:target/cucumber-reports.html", // HTML report
				"json:target/cucumber.json" // JSON report
		}, monochrome = true // Cleaner console output
)
public class TestRunner extends AbstractTestNGCucumberTests {
	// No additional code needed; TestNG + Cucumber handles the execution
}
