Feature: Checkout and Purchase
    As a customer
    I want to complete my purchase
    So that I can buy products from DemoBlaze

    Background:
        Given the user is on the home page
        And the user has items in the cart

    Scenario: Complete purchase with valid information
        Given the user is on the cart page
        When the user clicks the Place Order button
        Then the order form modal should appear
        When the user fills all mandatory fields with valid data
        And the user clicks the Purchase button
        Then a success message with order details should appear
        And the user should be redirected to the home page after clicking OK
