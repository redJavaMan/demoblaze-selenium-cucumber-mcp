package com.blaze.steps.LoginTest;

import io.cucumber.java.en.*;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import com.blaze.config.WebDriverManager;
import com.blaze.pages.HomePage;

public class UserLoginStep {
    private HomePage homePage;
    private String username;

    public UserLoginStep(WebDriverManager webDriverManager) {
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

    @Given("the user is logged in")
    public void userIsLoggedIn() {
        navigateToLoginPage();
        enterCredentials();
        verifyLoginSuccess();
    }

    @When("the user clicks on logout")
    public void userClicksOnLogout() {
        homePage.logout();
    }

    @Then("the user should be logged out successfully")
    public void userShouldBeLoggedOutSuccessfully() {
        assertTrue("Logged in username is still displayed after logout", homePage.userNameNotDisplayed());
    }

    @And("login and signup options should be visible")
    public void loginAndSignupOptionsVisible() {
        assertTrue("Login option is not visible", homePage.isLoginOptionDisplayed());
        assertTrue("Signup option is not visible", homePage.isSignUpOptionDisplayed());
    }
}
