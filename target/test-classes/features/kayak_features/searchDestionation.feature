
@kayakAirportSearch
  Feature: User should be able to select origin and destination airports

    Scenario Outline: User should be able to select origin and destination airports

      Given user is on the Kayak Landing Page
      When user enters "<origin>" by adding nearby airports and enters "<destination>" cities
      And user selects "05/12/2020" and "06/13/2020" dates
      And user clicks search button
      Then user validates origin and destination details are same as entered in the main screen


      Examples:

      |origin | destination|
      |Boston| Orlando    |
















