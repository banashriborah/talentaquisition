Feature: Suggesting activities from Bored API

  Scenario Outline: Generating three social activities for two people
    Given have a <activityType> activity
    When request <numberOfActivities> activities for <countOfPeople> people with type social
    Then should receive appropriate suggestions
    Examples:
      | activityType | numberOfActivities | countOfPeople |
      | "social"     | 3                  | 2             |