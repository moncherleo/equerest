Feature:
  As a entrepreneur
  I want to be able to register my new project
  So that I can see my project in projects catalogue

  Scenario Outline: Register a new project as entrepreneur
    Given I am on new project registration page
    When I fill my First Name "<firstName>" and Last Name "<lastName>" into Full Name field
    #Oleg
    And I fill my City "<city>" into City field
    And I fill my phone number "<telephone>" into Phone field
    #Eduard
    And I fill my email address "<mail>" into Email field
    And I fill my desired password "<password>" into Password field
    #Leonid
    And I set checkbox to show my password
    #Misha
    And I go next to second project registration page
    Then I should see form field with "Название проекта" title
    And I fill Project name "<projectName>" into projectName field
    And I fill Description of project "<projectDescription>" into description of project field
    And I select stage of project idea or prototip at project stage field
    And I fill advantages "Конкурентные преймущества" into Competitive advantages field
    And i fill Amount of investment "2000" into Amount of investment field
    And I fill monetization Model "Модель монетизации" into monetization Model field
    And I set checkbox at I agree with conditions and rules field
    And I go to finish registration page
    Then I should see the text "Спасибо!"
    And I shuld click to the Мой проект button
    Then I should see "<projectName>" project title

    Examples:
      | firstName | lastName   | mail          | password | city | telephone     | projectName       | projectDescription | stage             |
      | Leonid    | Chernyshov | test@test.com | Equerest | Kyiv | +380631324567 | тестовый проект 1 | Описание проекта   | Идея или прототип |