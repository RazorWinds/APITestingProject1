Feature: Update an existing Spartan

Scenario: Update to an existing Spartan
Given I have a valid bearer token
  And Disabled 4
And I use the ID 2  
And I have a valid JSON object with all the updated Spartans details
When I make a put request to Spartan
Then I should receive a 200 response code