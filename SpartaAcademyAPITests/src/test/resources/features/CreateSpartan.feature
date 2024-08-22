Feature: Creating new Spartans

Scenario: Adding a new Spartan
Given I have a valid bearer token
  And Disabled 3
And I have a valid JSON object with all the Spartans details
When I make a post request to Spartan
Then I should receive a 200 response code