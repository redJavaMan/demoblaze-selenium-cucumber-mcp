Feature: Home Page Verification
    As a user
    I want to see the home page of DemoBlaze
    So that I can navigate and access different features

    Scenario: Verify home page loads successfully
        When the user navigates to the application
        Then the home page should load successfully
        And the page title should display "STORE"
        And all page elements should be visible including logo, navigation menu, carousel, and footer

    Scenario: Verify product categories are displayed
        Given the user is on the home page
        When the user observes the product section
        Then products should be displayed with images, names, and prices
        And product categories like Phones, Laptops, and Monitors should be available

    Scenario: Verify navigation pagination
        Given the user is on the home page
        When the user scrolls to the product section
        Then Previous and Next buttons should be visible
        When the user clicks the Next button
        Then the next set of products should load
        When the user clicks the Previous button
        Then the previous set of products should load
