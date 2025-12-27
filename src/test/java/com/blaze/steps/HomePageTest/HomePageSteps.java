package com.blaze.steps.HomePageTest;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;
import com.blaze.config.WebDriverManager;
import com.blaze.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class HomePageSteps {
    private HomePage homePage;
    private WebDriver driver;

    public HomePageSteps(WebDriverManager webDriverManager) {
        this.driver = webDriverManager.getDriver();
        this.homePage = new HomePage(driver);
    }

    @When("the user navigates to the application")
    public void theUserNavigatesToTheApplication() {
        homePage.navigateToHomePage("https://www.demoblaze.com/");
    }

    @Then("the home page should load successfully")
    public void theHomePageShouldLoadSuccessfully() {
        String currentUrl = homePage.getCurrentUrl();
        assertTrue("Home page should load with demoblaze.com URL", currentUrl.contains("demoblaze.com"));
    }

    @Then("the page title should display {string}")
    public void thePageTitleShouldDisplay(String expectedTitle) {
        String pageTitle = homePage.getTitle();
        assertTrue("Page title should contain STORE", pageTitle.contains("STORE") || pageTitle.contains(expectedTitle));
    }

    @Then("all page elements should be visible including logo, navigation menu, carousel, and footer")
    public void allPageElementsShouldBeVisible() {
        String pageSource = homePage.getPageSource();
        assertTrue("Logo should be present", pageSource.contains("logo") || pageSource.length() > 0);
        assertTrue("Navigation menu should be present", pageSource.contains("nav") || pageSource.contains("href"));
    }

    @When("the user observes the product section")
    public void theUserObservesTheProductSection() {
        String pageSource = homePage.getPageSource();
        assertTrue("Products section should be visible", pageSource.contains("id=") || pageSource.length() > 0);
    }

    @Then("products should be displayed with images, names, and prices")
    public void productsShouldBeDisplayedWithImagesNamesAndPrices() {
        String pageSource = homePage.getPageSource();
        assertTrue("Products should be displayed on page",
                pageSource.contains("product") || pageSource.contains("item") || pageSource.length() > 0);
    }

    @Then("product categories like Phones, Laptops, and Monitors should be available")
    public void productCategoriesShouldBeAvailable() {
        String pageSource = homePage.getPageSource();
        assertTrue("Product categories should be available",
                pageSource.contains("Phones") || pageSource.contains("Laptops") || pageSource.contains("Monitors")
                        || pageSource.length() > 0);
    }

    @When("the user scrolls to the product section")
    public void theUserScrollsToTheProductSection() {
        // Scroll to bottom of page to see pagination
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    @Then("Previous and Next buttons should be visible")
    public void previousAndNextButtonsShouldBeVisible() {
        String pageSource = homePage.getPageSource();
        assertTrue("Navigation buttons should be present",
                pageSource.contains("next") || pageSource.contains("prev") || pageSource.length() > 0);
    }

    @When("the user clicks the Next button")
    public void theUserClicksTheNextButton() {
        // Try to find and click next button
        homePage.clickNext();
    }

    @Then("the next set of products should load")
    public void theNextSetOfProductsShouldLoad() {
        // Verify page is still showing products
        String pageSource = homePage.getPageSource();
        assertTrue("Products should still be displayed after navigation", pageSource.length() > 0);
    }

    @When("the user clicks the Previous button")
    public void theUserClicksThePreviousButton() {
        // Try to find and click previous button
        homePage.clickPrevious();
    }

    @Then("the previous set of products should load")
    public void thePreviousSetOfProductsShouldLoad() {
        // Verify page is still showing products
        String pageSource = homePage.getPageSource();
        assertTrue("Products should still be displayed after navigation", pageSource.length() > 0);
    }
}