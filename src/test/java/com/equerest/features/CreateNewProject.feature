Feature:
  As a entrepreneur
  I want to be able to register my new project
  So that I can see my project in projects catalogue

  Scenario Outline: Register a new project as entrepreneur
    Given I am on new project registration page
    When I fill my First Name "<firstName>" and Last Name "<lastName>" into Full Name field
    #Oleg
    And I fill my City "Kyiv" into City field
    And I fill my phone number "+3800000000000" into Phone field
    #Eduard
    And I fill my email address "my.email@address" into Email field
    And I fill my desired password "equerest" into Password field
    #Leonid
    And I set checkbox to show my password
    #Misha
    And I go next to second project registration page
    Then I should see form field with "Название проекта" title
    Examples:
      | firstName | lastName   |
      | Leonid    | Chernyshov |