Feature: User should be able to update a student on API and validate with UI-DB

  @updateStudentValidateE2E  @Regression
  Scenario: User should be able to update a student on API and validate with UI-DB

    Given user hits and PUT - Update a student on API "/student/update"
      | firstName        | Lionel                 |
      | lastName         | MESSI                  |
      | emailAddress     | lionel.messi@gmail.com |
      | joinDate         | 01/01/2011             |
      | password         | asd1234                 |
      | subject          | Math                   |
      | phone            | 3124756521             |
      | gender           | Male                   |
      | admissionNo      | 13                     |
      | birthDate        | 01/01/1998             |
      | major            | Math                   |
      | batch            | 10                     |
      | section          | BTT                    |
      | premanentAddress | 920 W Dearborn St.     |
      | companyName      | Barcelona              |
      | title            | Goat                   |
      | startDate        | 01/02/2019             |
      | city             | Barcelona              |
      | street           | 13 Addison             |
      | zipCode          | 60040                  |
      | state            | IL                     |
      | studentId        | 8050                   |
    When user is on the school home page
    And user is on the all students page
    And user searches student by 23456
    And user click on the student profile
    And user validates UI and API info about updated student
    When user connects to DB
    And user writes query about updated student
    Then user validates with DB, API and UI


