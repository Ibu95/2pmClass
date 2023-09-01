@chrome
Feature: Facebook Login In Chrome

  Background: 
    Given User Load the URL

  @smoke
  Scenario: Login With Valid Data
    When User Enter the UserName "Shivin"
    And User Enter the Password "Tech"
    And User Click the Login button
    Then Login Sucess valid

  @sanity
  Scenario: Login With InValid Data
    When User Enter the UserName "Shivn1"
    And User Enter the Password "Tech1"
    And User Click the Login button
    Then Login Sucess

  @reg
  Scenario Outline: Login With InValid Seq  Data
    When User Enter the UserName "<user>"
    And User Enter the Password "<pass>"
    And User Click the Login button
    Then Login Sucess

    Examples: 
      | user | pass |
      | Shv1 | Tec1 |
      | Shv2 | Tec2 |