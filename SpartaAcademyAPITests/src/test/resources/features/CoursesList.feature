Feature: List all courses

  Scenario: API call made to list all courses
    Given I have a valid bearer token
    When I request all courses
    Then The response should include a JSON array containing multiple courses

  Scenario: API call made to list all courses with no bearer token
    Given I have no bearer token
    And Disabled 1
    When I request all courses
    Then I should receive a 401 response code