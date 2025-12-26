package com.blaze.steps.LoginTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import com.blaze.config.WebDriverManager;
import com.blaze.pages.HomePage;

public class LoginTestStep {
    private HomePage homePage;
    private String username;

    public LoginTestStep(WebDriverManager webDriverManager) {
        homePage = new HomePage(webDriverManager.getDriver());
    }

    @Given("the user is on the home page")
    public void navigateToHomePage() {
        homePage.navigateToHomePage("https://www.demoblaze.com/");
    }

    @Given("the user is on the login page")
    public void navigateToLoginPage() {
        homePage.clickLogin();
        assertTrue("Login popup is not displayed", homePage.isLoginPopupDisplayed());
    }

    @When("the user enters a valid username and password")
    public void enterCredentials() {
        username = "test";
        homePage.login(username, "test");
    }

    @Then("the user should be logged in successfully")
    public void verifyLoginSuccess() {
        assertEquals("Logged in username does not match", "Welcome " + username, homePage.getLoggedInUsername());
    }

    @When("the user enters an invalid username or password")
    public void enterInvalidCredentials() {
        homePage.login("invalidUser", "invalidPass");
    }

    @Then("an allert box should be displayed with message {string}")
    public void verifyAlertMessage(String expectedMessage) {
        String alertText = homePage.getAlertTextAndAccept();
        assertEquals("Alert message does not match", expectedMessage, alertText);
        System.out.println("Alert message: " + alertText);
    }
}
