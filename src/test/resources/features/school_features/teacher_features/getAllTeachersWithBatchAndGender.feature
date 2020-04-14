
  Feature: User should be able to cross validate teacher batch and gender information between UI - DB - API
@CrossValidateGenderAndBatchBetweenUIDBAPI-E2E
    Scenario: User should be able to cross validate teacher batch and gender information between UI - DB - API and provide the number

      Given user connects to DB
      When user gets all teachers from Data Base
      And user gets the numbers of male and batch 10 teachers from Data Base
      Given user hits and GETs the teacher at "/teacher/all"
      And user gets all number of male and batch 10 teachers from API
      Given user is on the school home page
      And user is on the all teachers page
      When user gets all teachers from UI
      And user gets the number of male and batch 10 teachers from UI
      Then user cross validates number of male and batch 10 teachers between UI - DB - API



