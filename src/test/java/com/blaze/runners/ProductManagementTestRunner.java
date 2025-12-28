package com.blaze.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * ProductManagementTestRunner - Test runner for Product Management feature
 * tests
 * Executes all scenarios defined in ProductManagement.feature
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/ProductManagement.feature", glue = { "com.blaze.steps",
        "com.blaze.hooks" }, plugin = {
                "pretty",
                "html:target/html-report-productmanagement.html",
                "json:target/cucumber-productmanagement.json"
        }, monochrome = true, dryRun = false)
public class ProductManagementTestRunner {
}
