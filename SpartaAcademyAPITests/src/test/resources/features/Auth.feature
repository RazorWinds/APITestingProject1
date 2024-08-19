Feature: Login and Authentication

Scenario: Login with valid details
  Given I use the correct login details
  When I send a login request
  Then I should receive a auth token

Scenario: Login with invalid password
  Given I use a valid username but invalid password
  When I send a login request
  Then I should receive a 401 response code

Scenario: Login with invalid details
  Given I use invalid login details
  When I send a login request
  Then I should receive a 401 response code