Feature:
  As a entrepreneur
  I want to be able to register my new project
  So that I can see my project in projects catalogue

  Scenario: Register a new project as entrepreneur
    Given I am on new project registration page
    When I fill my First Name "Leonid" and Last Name "Chernyshov" into Full Name field
    And I fill my City "Kyiv" into City field
    And I fill my phone number "+3800000000000" into Phone field
    And I fill my email address "my.email@address" into Email field
    And I fill my desired password "equerest" into Password field
    And I set checkbox to show my password
    And I go next to second project registration page
    Then I should see form field with "Название проекта" title