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

  @Scenario02
  Scenario: Update User Full Name
    When clear and enter the full name field
    Then clicks the "Save" button

  @Scenario03
  Scenario: Update Gender
    When the user selects "Female" in the gender radio button
    Then the gender selection should be saved


  @Scenario04
  Scenario: Add an image to attachments and write a comment

    When the user clicks the "Add Attachment" button
    And the user selects an image file "profile.jpg" from their computer
    And the user enters "Profile picture added" in the comment field
    Then the user clicks the Save button

  @Scenario05
  Scenario: Delete attachment with confirmation

    When the user clicks delete icon for the attachment
    And confirms deletion in the popup
    Then delete the Attachment
