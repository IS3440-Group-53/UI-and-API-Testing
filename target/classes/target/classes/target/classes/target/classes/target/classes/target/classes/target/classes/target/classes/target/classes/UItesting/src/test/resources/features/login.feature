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
Feature: Dashboard UI Verification
  This feature verifies the functionality and UI elements of the dashboard.

  Scenario: Verify the presence of key widgets on the dashboard
    Given Open the application
    When Enter the valid username and password
    Then Verify the following widgets are present:
      | Widget Name       |
      | Employee Summary  |
      | Leave Requests    |
      | Quick Launch      |

  Scenario: Verify the "Admin" menu is accessible
    Given Open the application
    When Enter the valid username and password
    Then Verify the "Admin" menu is displayed
    And Navigate to "Admin" menu
    And Verify the "User Management" section is displayed
