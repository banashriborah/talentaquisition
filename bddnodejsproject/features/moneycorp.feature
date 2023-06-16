Feature: MoneyCorp Website Testing

  Scenario: Verify language and region change
    Given I open the MoneyCorp website
    When I change the language and region to "USA" "English"
    Then I should be on the result page

  Scenario: Verify "Find out more" for Foreign exchange solutions
    Given I open the MoneyCorp website
    When I click on 'Find out more' for Foreign exchange solutions
    Then I should be on the result page

  Scenario: Search for a keyword and validate result page
    Given I open the MoneyCorp website
    When I search for the word "<keyword>"
    Then I should be on the result page

  Scenario: Validate article links on the result page
    Given I open the MoneyCorp website
    When I search for the word "international payments"
    Then I should be on the result page
    And I should see each article link starting with 'https://www.moneycorp.com/en-us/'

  Scenario: Close the browser
    Given I open the MoneyCorp website
    Then I close the browser
