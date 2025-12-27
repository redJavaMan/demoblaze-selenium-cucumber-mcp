package com.blaze.steps.CheckOutTest;

import com.blaze.config.WebDriverManager;
import com.blaze.pages.CartPage;
import com.blaze.pages.HomePage;
import com.blaze.pages.ProductPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.junit.*;

public class CheckOutStep {
    private WebDriver driver;
    private HomePage homePage;
    private ProductPage productPage;
    private String productName;
    private CartPage cartPage;

    public CheckOutStep(WebDriverManager webDriverManager) {
        this.driver = webDriverManager.getDriver();
        this.homePage = new HomePage(driver);
        this.productPage = new ProductPage(driver);
        this.cartPage = new CartPage(driver);
    }

    @Given("the user has items in the cart")
    public void userHasItemsInCart() {
        productName = "Nokia lumia 1520";
        homePage.selectProduct(productName);
        Assert.assertEquals("Product does not match", productName, productPage.getProductName());
        productPage.addToCart();
        String alertText = productPage.acceptPopup();
        Assert.assertTrue("Alert message does not confirm addition to cart",
                alertText.contains("Product added"));
    }

    @Given("the user is on the cart page")
    public void userOnCartPage() {
        homePage.goToCart();
        Assert.assertTrue("User is not on cart page", homePage.getCurrentUrl().contains("cart"));
    }

    @When("the user clicks the Place Order button")
    public void userClicksPlaceOrderButton() {
        cartPage.placeOrder();
    }

    @Then("the order form modal should appear")
    public void orderFormModalAppears() {
        Assert.assertTrue("Order form modal is not displayed", cartPage.isOrderFormDisplayed());
    }

    @When("the user fills all mandatory fields with valid data")
    public void userFillsMandatoryFields() {
        cartPage.fillOrderForm("John Doe", "USA", "New York", "1234567890123456", "12", "2025");
    }

    @When("the user clicks the Purchase button")
    public void userClicksPurchaseButton() {
        cartPage.purchase();
    }

    @Then("a success message with order details should appear")
    public void successMessageAppears() {
        Assert.assertEquals("Success message does not match", "Thank you for your purchase!", cartPage.getSuccessMessage());
    }

    @Then("the user should be redirected to the home page after clicking OK")
    public void userRedirectedToHomePage() {
        cartPage.clickOk();
        cartPage.waitForUrlContains("index.html");
        Assert.assertTrue("User is not redirected to home page", homePage.getCurrentUrl().equals("https://www.demoblaze.com/index.html"));
    }
}
