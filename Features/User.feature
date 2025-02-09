Feature: Users

  Background: 
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And User enters Email as "Admin" and Password as "admin123"
    And Click on Login

  Scenario: Add New User
    Given Page Title should be "OrangeHRM"
    When User Navigate to the PIM menu and select ADD Employee
    Then Enter Employee First Name as "Dinesh" and Last Name as "Tayde"
    And Click on Save button
    Then Success message should contains "Success"
    Then close browser

  Scenario: Search User By Employee ID
    Given User Navigate to the PIM menu
    When User enter "0039" in Employee ID search field
    And Click on search button
    Then User should found Email in the Search Table
    Then close browser

  Scenario: Search User By Employee Name
    Given User Navigate to the PIM menu
    When User enter "Rahul" in Employee Name search field
    And Click on search button
    Then Verify that record is found in search table
    Then close browser

  Scenario: Search User By Employee Name
    Given User Navigate to the PIM menu
    When User select Full-Time Contract from Employee Status menu
    And Click on search button
    Then Verify that record is displayed
    Then close browser
