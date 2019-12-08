Feature: Like yandex mail user I want
  to create new package and new document
  inside the package

  Background:
    Given user is on login page
    And user logged in successfully

  @creating
  Scenario: Check that new package creating
    And user created new package
    And user open the package
    Then created package is correct

