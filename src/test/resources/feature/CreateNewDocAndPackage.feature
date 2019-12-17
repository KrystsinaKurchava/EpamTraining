Feature: Like yandex mail user I want
  to create new package and new document
  inside the package

  Background:
    Given user is on login page
    And user logged in successfully

  @all
  @creating
  Scenario: Check new package creating
    Given user created new package with name TestPackageName
    When user open the package TestPackageName
    Then created package name is TestPackageName

  @all
  @creating
  Scenario: Check new document creating
    Given user created new document with name TestDocumentName with text TestTextContain in package TestPackageName
    Then document TestDocumentName in package TestPackageName has text TestTextContain