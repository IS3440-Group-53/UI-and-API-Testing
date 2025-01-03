
Feature: Time Module Navigation and Customer Management
  As a logged in user
  I want to manage timesheets and customer information

#  Background:
#    Given Open the application
#    When Enter the valid username and password

  @timesheet-create
  Scenario: Create New Timesheet
    When I navigate to Time tab
    And I click on Timesheets dropdown
    And I select My Timesheet option
    And I click the previous button "5" times
    And I click Create Timesheet button
    And I click Submit button

  @timesheet
  Scenario: Edit Timesheet Information
    When I navigate to Time tab
    And I click on Timesheets dropdown
    And I select My Timesheet option
    And I edit the timesheet

  @customer
  Scenario: Create New Customer with Valid Details
    When I navigate to Time tab
    And I proceed to Project Info
    And I select Customers option
    And I create new customer with details:
      | name | description |
      | Nadun | Employee   |

  @customer-validation
  Scenario: Verify Required Field Validation for Customer Creation
    When I navigate to Time tab
    And I proceed to Project Info
    And I select Customers option
    And I attempt to create customer without name

  @edit-customer
  Scenario: Edit Customer Description
    When I navigate to Time tab
    And I proceed to Project Info
    And I select Customers option
    And I click the edit button for first customer
    And I clear the description field
    And I save the customer changes