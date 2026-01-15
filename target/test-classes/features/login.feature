Feature: Login functionality for the web application
  As a user of the application
  I want to login successfully with valid credentials
  So that I can access the dashboard

  Scenario: Successful login with valid credentials
    Given the user is on the login page
    When the user enters username "admin" and password "Admin@1"
    And clicks the login button
    Then the user should login successfully
    Then the user should logout from application

  Scenario: Login fails with invalid credentials
    Given the user is on the login page
    When the user enters username "wronguser" and password "wrongpass"
    And clicks the login button
    Then the user should see an error message "Invalid user id or password"
