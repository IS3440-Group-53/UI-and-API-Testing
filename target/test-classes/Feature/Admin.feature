

Feature: Navigate from My Info to Admin Page
  As a logged-in user
  I want to navigate to the Admin page
  So that I can manage administrative tasks
#  Background:
#    Given Open the application
#    When Enter the valid username and password


  @Scenario
  Scenario: Navigate to Admin Page
    When I am on the Dashboard page
    And I click on the "Admin" menuitem
    Then I can see the  Admin page Title

  @Scenario
  Scenario: Search a user by username
    When I search for a user with the following details
      | Username  |
      | johndoe   |
    Then I can see the user details matching the search criteria

#  @Scenario
#  Scenario: Reset the search fields
#    When I enter search criteria in the fields
##      | Username  |
##      | johndoe   |
#    And I click on the Reset button
#    Then all the search fields should be cleared

#
#
#  @Scenario
#  Scenario: Add a new user
#    When I add a new user with the following details
#      |Role|EmployeeName|Status|Username|Password|ConfirmPassword|
#      |Admin|James  Butler|Enabled|johndoe|Admin12345#|Admin12345#|
#
#
#  @Scenario
#  Scenario: Edit an existing user
#    When I edit the user with the following details
#      | User Role  | Employee Name  | Status  | Username |
#      | Admin      | John Doe       | Enabled | johndoe  |
##    Then I should see the user updated successfully



