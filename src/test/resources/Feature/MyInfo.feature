Feature: Navigate from Dashboard to My Info Page
  As a logged-in user
  I want to navigate to the My Info page
  So that I can view and update my personal information
#Background:
#  Given Open the application
#  When Enter the valid username and password

  @Scenario01
  Scenario: Navigate to My Info Page
 When I am on the Dashboard page
    And I click on the "My Info" menu
Then I should be navigated to the My Info page


#  @Scenario02
#  Scenario: User updates personal details
##    Given the user is logged in to OrangeHRM
##    And the user is on the My Info page
#    When the user updates the personal details with valid data
#    And clicks the Save button
#    Then the updated details should be displayed correctly
