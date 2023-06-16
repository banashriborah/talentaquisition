Feature: MoneyCorp Website Testing
@ScenarioThatWorks
  Scenario Outline: Verify language and region change
    Given open the MoneyCorp website
    When change the language and region to <language> <region>
    Then should be on the result page <region>

    Examples:
      | language | region |
      | English  | France |
      | English  | Canada |

#below scenarios doesnt hold good ,and wont work as the Ui doesnt have the required fields and components .
# but based on my understanding i just added the requisite step def and code ,so in future if you want to adopt can refer my code


  Scenario: Verify "Find out more" for Foreign exchange solutions
    Given I open the MoneyCorp website
    When I click on 'Find out more' for Foreign exchange solutions
    Then I should be on the result page

  Scenario Outline: Search for a keyword and validate result page
    Given I open the MoneyCorp website
    When I search for the word "<keyword>"
    Then I should be on the result page

    Examples:
      | keyword                  |
      | international payments   |
      | foreign currency exchange |
      | international transfers   |

  Scenario: Validate article links on the result page
    Given I open the MoneyCorp website
    When I search for the word "international payments"
    Then I should be on the result page
    And I should see each article link starting with url

  Scenario: Close the browser
    Given I open the MoneyCorp website
    Then I close the browser
