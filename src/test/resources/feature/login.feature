Feature: Yandex login
  As a yandex mail user I want
  to see my mail box after successful login

  Background:
    Given user is on login page

  @all
  Scenario Outline: Successful login with valid credentials
    Given user has valid credentials
    When user clicks login button
    And user enters <login> login
    And user enters  <password> password
    And user clicks sign in button
    Then user is on Personal page
    Examples:
      | login                 | password        |
      | kkurcheva             | yuF3hq5eXPhJXLd |
      | krystsinademokurchava | Nmbpp3kwdRE5VQA |
  @all
  Scenario: Unsuccessful login with invalid login
    Given user has invalid login
    When user clicks login button
    And user enters login
    Then user has error Логин не указан
  @all
  Scenario: Unsuccessful login with invalid password
    Given user has invalid password
    When user clicks login button
    And user enters login
    And user enters password
    And user clicks sign in button
    Then user has error Пароль не указан