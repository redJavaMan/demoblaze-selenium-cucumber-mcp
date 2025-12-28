package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * ProductDetailsPage - Page object for individual product details page
 * Handles interactions with product details, image, price, description, and add
 * to cart
 */
public class ProductDetailsPage extends BasePage {

    // LOCATORS
    @FindBy(xpath = "//div[@id='tbodyid']//h2")
    private WebElement productName;

    @FindBy(xpath = "//div[@id='tbodyid']//p[1]")
    private WebElement productPrice;

    @FindBy(xpath = "//div[@id='tbodyid']//p[2]")
    private WebElement productDescription;

    @FindBy(xpath = "//img[@class='img-thumbnail']")
    private WebElement productImage;

    @FindBy(xpath = "//a[text()='Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = "//a[contains(@class, 'btn-danger')]")
    private WebElement backButton;

    /**
     * Constructor - initializes ProductDetailsPage with WebDriver
     * 
     * @param driver - WebDriver instance
     */
    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get product name displayed on details page
     * 
     * @return product name as string
     */
    public String getProductName() {
        return getText(productName);
    }

    /**
     * Get product price displayed on details page
     * 
     * @return product price as string
     */
    public String getProductPrice() {
        return getText(productPrice);
    }

    /**
     * Get product description displayed on details page
     * 
     * @return product description as string
     */
    public String getProductDescription() {
        return getText(productDescription);
    }

    /**
     * Check if product image is displayed
     * 
     * @return true if image is visible
     */
    public boolean isProductImageDisplayed() {
        return isDisplayed(productImage);
    }

    /**
     * Check if product name is displayed
     * 
     * @return true if product name is visible
     */
    public boolean isProductNameDisplayed() {
        return isDisplayed(productName);
    }

    /**
     * Check if product price is displayed
     * 
     * @return true if product price is visible
     */
    public boolean isProductPriceDisplayed() {
        return isDisplayed(productPrice);
    }

    /**
     * Check if product description is displayed
     * 
     * @return true if product description is visible
     */
    public boolean isProductDescriptionDisplayed() {
        return isDisplayed(productDescription);
    }

    /**
     * Check if Add to Cart button is visible
     * 
     * @return true if button is displayed
     */
    public boolean isAddToCartButtonVisible() {
        return isDisplayed(addToCartButton);
    }

    /**
     * Check if Add to Cart button is enabled
     * 
     * @return true if button is enabled
     */
    public boolean isAddToCartButtonEnabled() {
        return addToCartButton.isEnabled();
    }

    /**
     * Click Add to Cart button
     */
    public void clickAddToCart() {
        click(addToCartButton);
    }

    /**
     * Get and accept alert after adding to cart
     * 
     * @return alert message text
     */
    public String acceptAddToCartAlert() {
        String alertText = alert().getText();
        alert().accept();
        return alertText;
    }

    /**
     * Check if all product information is displayed
     * 
     * @return true if name, price, description, and image are all visible
     */
    public boolean isAllProductInfoDisplayed() {
        return isProductNameDisplayed() &&
                isProductPriceDisplayed() &&
                isProductDescriptionDisplayed() &&
                isProductImageDisplayed();
    }

    /**
     * Click back button to return to product list
     */
    public void clickBackButton() {
        click(backButton);
    }

    /**
     * Wait for product details page to load completely
     */
    public void waitForProductDetailsToLoad() {
        waitForPageLoadComplete();
    }
}
