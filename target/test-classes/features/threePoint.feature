
Feature: Verify the Info from all environments
  @wip
  Scenario: Get the Info from UI
    Given User logs in with "sbirdbj@fc2.com" and "asenorval"
    When User navigates to mySelf page
    Then User gets the UI info

  Scenario: Get the info from API
    When User logs in BookIT API using "sbirdbj@fc2.com" and "asenorval"
    Then User gets API information


  Scenario: Get the info from DB
    When User sens a query to DataBase with "sbirdbj@fc2.com"
    Then User gets DB info

