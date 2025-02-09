Feature: Login

  Background: 
    Given User Launch Chrome browser
    When User opens URL "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"

  Scenario: Verify Successful Login with Valid Credentials
    When User enters Email as "Admin" and Password as "admin123"
    And Click on Login
    Then Page Title should be "OrangeHRM"
    Then Click on the User Profile and then on Logout button
    Then Page URL should be "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    And close browser

  Scenario Outline: Verify Login with Various Invalid Credentials DDT
    When User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then I should see following errors "<expected_result>" at "<messageLocator>"
    Then close browser

    Examples: 
      | email    | password | expected_result     | messageLocator                                                                    |
      | Admin    | admin    | Invalid credentials | css:.oxd-text.oxd-text--p.oxd-alert-content-text                                  |
      |    22233 | admin123 | Invalid credentials | css:.oxd-text.oxd-text--p.oxd-alert-content-text                                  |
      | admin111 |    22211 | Invalid credentials | css:.oxd-text.oxd-text--p.oxd-alert-content-text                                  |
      |          |          | Required            | xpath://*[@id=\\"app\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span |
      | Admin    |          | Required            | xpath://*[@id=\\"app\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span |
      |          | admin123 | Required            | xpath://*[@id=\\"app\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span |
      |          |   123333 | Required            | xpath://*[@id=\\"app\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span |
      |   222224 |          | Required            | xpath://*[@id=\\"app\\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/span |

  Scenario: Verify that Forgot your password? link is visible and enabled
    Then Forgot your password link is visible and enabled
    Then close browser

  Scenario: Verify that user is navigate to Reset Password page
    When User clicks on Forgot your password? link
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"
    Then close browser

  Scenario: Verify that if you have click on forgotten your password? And then by clicking the reset button
    and attempting to reset the password without providing the email address,
    then seeing if an error message appears.

    When User clicks on Forgot your password? link
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"
    And Click on Reset Password button
    Then User should see Required alert.
    Then close browser

  Scenario: Verify the forget password functionality with a valid email address and check if the password reset link is sent successfully.
    When User clicks on Forgot your password? link
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"
    Then User enter "Admin" in usename field
    And Click on Reset Password button
    Then User should see the message "Reset Password link sent successfully"
    Then close browser

  Scenario: Verify the forget password functionality with an valid email address clicks on cancel button.
    When User clicks on Forgot your password? link
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/requestPasswordResetCode"
    When User enter "Admin" in usename field
    And User clicks on Cancel button
    Then User should navigate to "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    Then close browser
