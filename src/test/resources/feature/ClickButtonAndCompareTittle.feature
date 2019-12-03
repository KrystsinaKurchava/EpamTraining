Feature: Work with yandex mail
  As a yandex mail user I want
  to see that button click is load correct page

  Background:
    Given user is on login page
    And user logged in successfully

  @workWithMail
  Scenario Outline: Check that user is on the correct page after his click on Trash button
    When user wants to click <name> button which has <system> name
    Then <expected> title ang getted title is equal

    Examples:
      | name          | system  | expected     |
#      | Trash         | Trash   | Trash        |
#      | File          | disk    | Files        |
#      | Public access | shared  | Public links |
#      | History       | journal | History      |
#   | Archive       | mail    | Archive      |
      | Newest          | recent  | Recent |
      | Photo         | photo   | All photos   |



