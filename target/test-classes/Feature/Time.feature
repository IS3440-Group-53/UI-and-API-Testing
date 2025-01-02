
Feature: Time Module Navigation and Attendance
  As a logged in user
  I want to access timesheet and punch in/out attendance

  Scenario: Edit Timesheet and Punch In
    Given Open the application
    When Enter the valid username and password
    And I navigate to Time tab
    And I click on Timesheets tab
    And I select My Timesheets
    And I edit the timesheet
    And I proceed to Attendance