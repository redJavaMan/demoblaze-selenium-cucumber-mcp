package com.blaze.pages;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//div[@id='tbodyid']//h2")
    private WebElement productName;

    public ProductPage(WebDriver driver) {
        super(driver);
    }
    
    public void addToCart() {
        click(addToCartButton);
    }

    public String getProductName() {
        return getText(productName);
    }

    public String acceptPopup() {
        Alert alert = alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }
}
