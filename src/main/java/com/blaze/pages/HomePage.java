package com.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class HomePage extends BasePage {
    @FindBy(id = "loginusername")
    private WebElement usernameField;

    @FindBy(id = "loginpassword")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@onclick='logIn()']")
    private WebElement loginButton;

    @FindBy(id = "login2")
    private WebElement login;

    @FindBy(css = "h5#logInModalLabel")
    private WebElement loginText;

    @FindBy(id = "nameofuser")
    private WebElement loggedInUser;

    @FindBy(id = "logout2")
    private WebElement logOut;

    @FindBy(id = "signin2")
    private WebElement signUp;

    @FindBy(xpath = "//button[contains(text(), 'Next')]")
    private WebElement nextButton;

    @FindBy(xpath = "//button[contains(text(), 'Previous')]")
    private WebElement previousButton;

    @FindBy(css = "a.hrefch")
    private List<WebElement> productsLink;

    @FindBy(xpath = "//a[text()='Cart']")
    private WebElement cartLink;

    @FindBy(id = "cat")
    private WebElement category;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToHomePage(String url) {
        navigateTo(url);
        waitForUrlContains(url);
    }

    public void clickLogin() {
        click(login);
    }

    public void login(String username, String password) {
        type(usernameField, username);
        type(passwordField, password);
        click(loginButton);
    }

    public boolean isLoginPopupDisplayed() {
        return isDisplayed(loginText);
    }

    public String getLoggedInUsername() {
        return getText(loggedInUser);
    }

    public String getAlertTextAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        System.out.println("Alert text: " + alertText);
        return alertText;
    }

    public void logout() {
        click(logOut);
    }

    public boolean userNameNotDisplayed() {
        return !isDisplayed(loggedInUser);
    }

    public boolean isLoginOptionDisplayed() {
        return isDisplayed(login);
    }

    public boolean isSignUpOptionDisplayed() {
        return isDisplayed(signUp);
    }

    public void clickNext() {
        click(nextButton);
    }

    public void clickPrevious() {
        click(previousButton);
    }

    public void selectProduct(String productName) {
        for(WebElement product: productsLink){
            if(product.getText().equalsIgnoreCase(productName)){
                click(product);
                break;
            }
        }
    }

    public void goToCart() {
        click(cartLink);
    }

    public boolean isCategoryDisplayed() {
        return isDisplayed(category);
    }
}
