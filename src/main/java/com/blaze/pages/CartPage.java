package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    @FindBy(xpath = "//button[text()='Place Order']")
    private WebElement placeOrderButton;

    @FindBy(id = "name")
    private WebElement namefield;

    @FindBy(id = "country")
    private WebElement countryField;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "card")
    private WebElement cardField;

    @FindBy(id = "month")
    private WebElement monthField;

    @FindBy(id = "year")
    private WebElement yearField;

    @FindBy(xpath = "//button[text()='Purchase']")
    private WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(),'Thank you')]")
    private WebElement successMessage;

    @FindBy(css = "button.confirm")
    private WebElement okButton;

    @FindBy(id = "orderModalLabel")
    private WebElement orderForm;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void placeOrder() {
        click(placeOrderButton);
    }

    public void fillOrderForm(String name, String country, String city, String card, String month, String year) {
        type(namefield, name);
        type(countryField, country);
        type(cityField, city);
        type(cardField, card);
        type(monthField, month);
        type(yearField, year);
    }

    public void purchase() {
        click(purchaseButton);
    }

    public boolean isOrderFormDisplayed() {
        return isDisplayed(orderForm);
    }

    public String getSuccessMessage() {
        return getText(successMessage);
    }

    public void clickOk() {
        wait.until(ExpectedConditions.elementToBeClickable(okButton));
        click(okButton);
    }
}