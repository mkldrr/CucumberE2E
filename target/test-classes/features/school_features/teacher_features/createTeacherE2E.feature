
  Feature: User should be able to create a teacher from API
    @CreatingTeacherE2E  @Regression

    Scenario: Creating teacher on API  and comparing with UI

      Given user hits and POST a teacher on API "/teacher/create"
      |firstName   | Lionel |
      |lastName    |Messi   |
      |joinDate    |01/01/2010|
      |emailAddress| lionel@gmail.com|
      |salary      |100000          |
      |batch       | 10              |
      |gender      |male             |
      |phone       |312000000        |
      |subject     |sport            |
      |section     |barca            |
      |birthDate   |01/02/1990       |
      |department  |math             |
      |password    |12345jhbk        |
      |premanentAddress| 7879 W Huron|

      When user is on the school home page
      And user search teacher by 12345
      And user click on the teacher profile
      Then user compares UI information and API information


