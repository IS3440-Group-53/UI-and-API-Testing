Feature: Time Module Navigation and Customer Management
  As a logged in user
  I want to manage timesheets and customer information

  Background:
    Given Open the application
    When Enter the valid username and password

  @timesheet-create
  Scenario: Create New Timesheet
    When I navigate to Time tab
    And I click on Timesheets dropdown
    And I select My Timesheet option
    And I click the previous button "4" times
    And I click Create Timesheet button
    And I click Submit button
    Then The new timesheet should be created

  @timesheet
  Scenario: Edit Timesheet Information
    When I navigate to Time tab
    And I click on Timesheets tab
    And I select My Timesheets
    And I edit the timesheet
    Then The timesheet should be saved successfully

  @customer
  Scenario: Create New Customer with Valid Details
    When I navigate to Time tab
    And I proceed to Project Info
    And I create new customer with details:
      | name | description |
      | Safd | Employee   |
    Then The customer should be created successfully

  @customer-validation
  Scenario: Verify Required Field Validation for Customer Creation
    When I navigate to Time tab
    And I proceed to Project Info
    And I attempt to create customer without name
    Then I should see the required field validation message