package com.blaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features = "src/test/resources/features/HomePage.feature", 
    glue = { "com.blaze.steps", "com.blaze.hooks" }, 
    plugin = { "pretty", "html:target/html-report-homepage.html" }, 
    monochrome = true, 
    dryRun = false)
public class HomePageTestRunner {
}
