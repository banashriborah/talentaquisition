Feature: MoneyCorp Website Testing

  @question2
  Scenario: Verify question2
    Given open the MoneyCorp website
    When change the language and region to USA(English)
    Then verify the region is displayed
    And click on find out more for Foreign exchange Solutions
    Then validate right page is arrived
    And click on searchbox to find internationalpayments
    Then validate result page is arrived
    And click show more results until not available
    Then verify all articles has link starting with


