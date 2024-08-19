Feature: Get course by ID

  Scenario: API call made to get a certain course
  Given I have a valid bearer token
  And I use a valid ID
  When I request a course
  Then The response should include the correct course details

  Scenario: API call made to to get a certain course with no auth
  Given I have no bearer token
    And Disabled 2
  And I use a valid ID
  When I request a course
  Then I should receive a 401 response code

  Scenario: API call made to to get a certain course with an invalid ID
  Given I have no bearer token
  And I use an invalid ID
  When I request a course
  Then I should receive a 204 response code