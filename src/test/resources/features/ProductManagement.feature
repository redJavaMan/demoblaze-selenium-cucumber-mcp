Feature: Product Management
    As a customer
    I want to view, search, and manage products
    So that I can find and purchase items I need

    Scenario: Verify product listing by category - Phones
        Given the user is on the home page
        When the user clicks on the Phones category
        Then phone products should be filtered and displayed

    Scenario: Verify product listing by category - Laptops
        Given the user is on the home page
        When the user clicks on the Laptops category
        Then laptop products should be filtered and displayed

    Scenario: Verify product listing by category - Monitors
        Given the user is on the home page
        When the user clicks on the Monitors category
        Then monitor products should be filtered and displayed

    Scenario: Verify product details page
        Given the user is on the home page
        When the user clicks on any product
        Then the product details page should open
        And product information including image, name, price, and description should be displayed
        And the Add to cart button should be visible and enabled
