
  Feature: User should be able to see majors

    @GetAllStudentsCrossValidateNamesAndMajors @Regression
    Scenario: user should be able to cross validate majors between API-UI and DB


      Given user hits and GETs all students from API at "/student/all"
      Given user connects to DB
      When user gets all students from DB
      Given user is on the school home page
      When user is on the all students page
      When user stores the list of students from UI
      Then user cross validates major and first between DB-UI-API







