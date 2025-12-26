package com.blaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", // Path to the feature files
                glue = { "com.blaze.steps", "com.blaze.hooks" }, // Path to the step definitions and hooks
                // tags = "@productSearch", // Tag to filter which scenarios to run
                plugin = { "pretty", "html:target/html-report.html" }, // Plugins for reporting
                monochrome = true, // Display the console output in a readable way
                dryRun = false // Check if all steps are defined in step definitions
)
public class LoginTestRunner {
}
