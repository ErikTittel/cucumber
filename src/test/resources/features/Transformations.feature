Feature: Transform input data

  In order to convert strings from the Cucumber feature files
  as a developer
  I want to use Transformers to initialize real objects from simple text input.

  Scenario: Read list
    Given the list of values: apple, banana, kiwi
    When I read the list
    Then I should get: apple, banana, kiwi

  Scenario: Object from table
    Given I have a fruit with the following details
      | name | apple |
      | colour | green |
    When the fruit becomes ripe
    Then the colour is red.

    # objects from strings
    # doc strings