@UpdateTeachersGender
Feature: User should be able to get all teachers from API

  Scenario Outline: User should be able to get all teachers from API

    Given user hits and GETs the teacher at "<resource>"
    When user checks the number of male teacher
    Then user updates the number of male teachers gender to female

    Examples:

    |resource|
    |/teacher/all|
