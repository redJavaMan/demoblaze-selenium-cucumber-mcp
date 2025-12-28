package com.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;

/**
 * ProductListPage - Page object for filtered product listing page
 * Handles interactions with product list filtered by categories
 */
public class ProductListPage extends BasePage {

    // LOCATORS
    @FindBy(css = "div#tbodyid div.col-lg-4")
    private List<WebElement> productCards;

    @FindBy(xpath = "//div[@id='tbodyid']//div[@class='col-lg-4']//h4/a")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@id='tbodyid']//div[@class='col-lg-4']//h5")
    private List<WebElement> productPrices;

    @FindBy(xpath = "//div[@id='tbodyid']//div[@class='col-lg-4']//p")
    private List<WebElement> productDescriptions;

    @FindBy(id = "cat")
    private WebElement categoryFilter;

    /**
     * Constructor - initializes ProductListPage with WebDriver
     * 
     * @param driver - WebDriver instance
     */
    public ProductListPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Get count of products displayed on the page
     * 
     * @return number of product cards visible
     */
    public int getProductCount() {
        return productCards.size();
    }

    /**
     * Verify if products are filtered and displayed
     * 
     * @return true if at least one product is displayed
     */
    public boolean areProductsDisplayed() {
        return getProductCount() > 0;
    }

    /**
     * Get list of all product names displayed
     * 
     * @return List of product names as strings
     */
    public List<String> getAllProductNames() {
        List<String> names = new java.util.ArrayList<>();
        for (WebElement product : productNames) {
            names.add(getText(product));
        }
        return names;
    }

    /**
     * Click on first product in the list
     */
    public void clickFirstProduct() {
        if (productNames.size() > 0) {
            click(productNames.get(0));
        }
    }

    /**
     * Click on product by name
     * 
     * @param productName - Name of the product to select
     */
    public void selectProductByName(String productName) {
        for (WebElement product : productNames) {
            if (getText(product).equalsIgnoreCase(productName)) {
                click(product);
                break;
            }
        }
    }

    /**
     * Verify if products are from a specific category
     * (Based on product names or descriptions)
     * 
     * @param categoryKeyword - Keyword to search in product names
     * @return true if products match the category
     */
    public boolean verifyProductsMatchCategory(String categoryKeyword) {
        List<String> productList = getAllProductNames();
        if (productList.isEmpty()) {
            return false;
        }

        for (String product : productList) {
            if (product.toLowerCase().contains(categoryKeyword.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Wait for product list to load
     */
    public void waitForProductsToLoad() {
        waitForPageLoadComplete();
    }
}
