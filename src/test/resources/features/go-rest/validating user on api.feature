Feature:  Using http methods on api level


  @APIUserValidate
  Scenario:  User should be able do create and delete a user on API

    Given user gets all clients from "resource"
    When user validate that specific "name" is not on API
    When user creates a client on given "resource"

    Then user deletes the already created client "id" on API and validate


