Feature: User Authentication
  As a user
  I want to authenticate with the DemoBlaze application
  So that I can access my account and personalized features

  Background:
    Given the user is on the home page
  
  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters a valid username and password
    Then the user should be logged in successfully
    And welcome message should display the logged in username

  Scenario: Unsuccessful login with invalid credentials
    Given the user is on the login page
    When the user enters an invalid username or password
    Then an allert box should be displayed with message "Wrong password."

  Scenario: Logout functionality
    Given the user is logged in
    When the user clicks on logout
    Then the user should be logged out successfully
    And login and signup options should be visible
