Feature: Like yandex mail user I want
  to create new package and new document
  inside the package

  Background:
    Given user is on login page
    And user logged in successfully

  @all
  @creating
  Scenario: Check new package creating
    Given user created new package with name TestPackage
    When user open the package TestPackage
    Then created package name is TestPackage

  @all
  @creating
  Scenario: Check new document creating
    Given user created new document with name TestDocument with text TestText in package TestPackage
    Then document TestDocument in package TestPackage has text TestText

