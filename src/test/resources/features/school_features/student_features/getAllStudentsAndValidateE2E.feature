
  Feature: User should be able to get all students and cross validate information
@getAllStudentsAndCrossValidateInformationE2E
    Scenario: User should compare firstName, Major between DB-API-UI and should compare companyName
    between DB-API and Should check how many address contains @ sign


      Given user connects to DB
      Given user gets all students from DB
      Given user hits and GETs all students from API at "/student/all"
      Given user is on the school home page
      When user is on the all students page
      And user stores the list of students from UI
      Then user cross validates firstNames and Major between UI-DB-API
      Given user gets companyName and emailAddress from DB
      Then user cross validates CompanyName and check how many EmailAddress has @ sign



