Feature: Delete a spartan

Scenario: Deleting Spartan
Given I have a valid bearer token
And I use the ID 7
When I make a delete request to the Spartan endpoint
Then I should receive a 204 response code
