
  Feature: User should be able to get all vehicle information
@getAllVehicleModelName  @Regression
    Scenario:  User should be able to get all vehicle information

      Given user login vyTrack Web Application
      When user is on the All Vehicles Module
      Then user gets all vehicles model name
