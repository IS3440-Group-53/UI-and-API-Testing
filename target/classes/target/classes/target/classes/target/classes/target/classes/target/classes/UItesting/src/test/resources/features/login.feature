Feature: To verify valid username and valid password
  This feature talk about login functionality.

  Scenario: verify valid username and valid password
    Given Open the application
    When Enter the valid username and password
    Then verify login should successfully done.
  Scenario: Verify dashboard elements after login
    Given Open the application
    When Enter the valid username and password
    Then Verify key elements on the dashboard
  Scenario: Verify the presence of widgets on the dashboard
    Given Open the application
    When Enter the valid username and password
    Then Verify the following widgets are present on the dashboard:
      | Widget Name                      |
      | Employee Distribution by Subunit |
      | Quick Launch                     |

