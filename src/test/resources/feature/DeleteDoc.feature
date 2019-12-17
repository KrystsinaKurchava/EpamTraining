Feature: Like yandex mail user I want
  to create new package and new document
  inside the package

  Background:
    Given user is on login page
    And user logged in successfully

  @all
  @cleaning
  Scenario: Check new document deleting
    Given user deleted document with name TestDocument from package TestPackage
    Then document TestDocument does not exist in package TestPackage
    And document TestDocument is in trash

  @all
  @cleaning
  Scenario: Check trash cleaning
    Given user cleaned trash
    Then trash doesn't contain document TestDocument