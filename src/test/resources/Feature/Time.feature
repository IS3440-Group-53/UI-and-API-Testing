#Feature: Time Module Navigation
#  As a logged in user
#  I want to access my timesheet
#  So that I can view my time records
#
#  Background:
#    Given Open the application
#    When Enter the valid username and password
#
#  Scenario: Access My Timesheet
#    When I navigate to Time tab
#    And I click on Timesheets tab
#    And I select My Timesheets
#    Then I should see the Time page



Feature: Time Module Navigation and Timesheet Edit
  As a logged in user
  I want to access and edit my timesheet

  Scenario: Edit My Timesheet
    Given Open the application
    When Enter the valid username and password
    And I navigate to Time tab
    And I click on Timesheets tab
    And I select My Timesheets
    And I edit the timesheet