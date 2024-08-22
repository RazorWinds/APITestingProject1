Feature: Get a Spartan by ID

Scenario: API call made to get a certain Spartan
Given I have a valid bearer token
And I use the ID 1
When I request a Spartan
Then The response should include the correct Spartan details

Scenario: API call made to to get a certain Spartan with no auth
Given I have no bearer token
And I use the ID 1
When I request a Spartan
Then I should receive a 401 response code

Scenario: API call made to to get a certain Spartan with an invalid ID
Given I have a valid bearer token
And I use the ID 10000
When I request a Spartan
Then I should receive a 204 response code