Feature: Navigate from My Info to Admin Page
  As a logged-in user
  I want to navigate to the Admin page
  So that I can manage administrative tasks
#Background:
#  Given Open the application
#  When Enter the valid username and password

  Scenario: Navigate to Admin Page
    When I am on the My Info page
    And I click on the "Admin" menu
    Then I should be navigated to the Admin page


#  @Scenario02
#  Scenario: User updates personal details
##    Given the user is logged in to OrangeHRM
##    And the user is on the My Info page
#    When the user updates the personal details with valid data
#    And clicks the Save button
#    Then the updated details should be displayed correctly
