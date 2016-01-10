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
      | name   | apple |
      | colour | green |
    When the fruit becomes ripe
    Then the colour is red.

  Scenario: Horizontal Table
    Given I have the following list of fruit
      | Name   | Weight In Grams |
      | apple  | 350             |
      | banana | 200             |
    When the fruit gains weight
    Then the fruit match the following details
      | Name   | Weight In Grams |
      | apple  | 500             |
      | banana | 400             |

  Scenario: Doc Strings
    Given I have the following text
    """
    Hello
    """
    When I process the text
    Then it should be equals to the following
    """
    World
    """