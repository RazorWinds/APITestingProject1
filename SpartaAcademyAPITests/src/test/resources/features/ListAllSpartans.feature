Feature: List all Spartans

Scenario: API call made to list all Spartans
Given I have a valid bearer token
When I request all Spartans
Then The response should include a JSON array containing multiple Spartans

Scenario: API call made to list all courses without a bearer token
Given I have no bearer token
When I request all Spartans
Then I should receive a 401 response code