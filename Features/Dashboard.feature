Feature: Login

  Background: 
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Verify that after successful login with valid credentials the dashboard loads correctly.
    	(Dashboard includes Time at Work,My Actions,Quick Launch, Buzz Latest Posts,
    	 Employees on Leave Today, Employee Distribution by Sub Unit,
    	 Employee Distribution by Location)

    When User enters Email as "Admin" and Password as "admin123"
    And Click on Login
    Then Dashboard components should be displayed.
    Then close browser

  Scenario: Verify that username is displayed in dashboard after successful login.
    When User enters Email as "Admin" and Password as "admin123"
    And Click on Login
    Then username should be "ShehanRamesh RaoShah"
    Then close browser

  Scenario: Verify that Logout Link in user profile is visible and enabled.
    When User enters Email as "Admin" and Password as "admin123"
    And Click on Login
    When User clicks on user profile
    Then Logout link should be displayed
    Then close browser

  Scenario: Verify that after clicking on Logout link user is redirected to login page.
    When User enters Email as "Admin" and Password as "admin123"
    And Click on Login
    When User clicks on user profile
    And Clicks on logout link
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    Then close browser
