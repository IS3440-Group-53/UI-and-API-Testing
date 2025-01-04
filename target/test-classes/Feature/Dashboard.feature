Feature: Validate Dashboard Page
  As a logged-in user
  I want to access the Dashboard page
  So that I can view the overview of the application

  @DashboardTest
  Scenario: Verify Dashboard Page
    When I am logged into the application
    Then I should see the Dashboard page

  @WidgetTest
  Scenario: Verify all widgets on the Dashboard
    When I am on the Dashboard page
    Then I should see all widgets on the Dashboard

  @UserProfileMenuTest
  Scenario: Verify user profile menu options
    When I click on the user profile menu
    Then I should see options like Logout and About

  @ResponsivenessTest
  Scenario: Verify Dashboard responsiveness across screen sizes
    When I am on the Dashboard page
    Then I validate responsiveness of the Dashboard at various screen sizes

  @ValidatePendingLeaveRequests
  Scenario: Verify Pending Leave Requests widget functionality
    When I navigate to the Dashboard page and locate the Pending Leave Requests widget

  @SearchBarFunctionality
  Scenario: Verify search bar functionality on the Dashboard
    When I type "Admin" into the search bar on the Dashboard
    And I should see results relevant to "Admin"
    Then the Dashboard is restored to its default state after clearing the search bar