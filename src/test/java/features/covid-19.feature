Feature: Covid-19 API

  @Regression
  Scenario Outline: Valid Case: Get covid-19 data for specific country
    Given country name "<ValidCountryName>" in the path parameter
    When calling Get API and the response received
    Then the response code should be 200
    Examples:
      | ValidCountryName |
      | Canada           |

  Scenario Outline: Invalid Case: Get covid-19 data for specific country
    Given country name "<InvalidCountryName>" in the path parameter
    When calling Get API and the response received
    Then the response code should be 404
    Examples:
      | InvalidCountryName |
      | APC                |


  @Webhook
  Scenario Outline: Add webhook to get new daily data for covid-19
    Given url "<URL>" in th payload
    When calling Post API and the response received
    Then the response code should be 200
    Examples:
      | URL                 |
      | https://www.apc.com |

  Scenario Outline: Add webhook to get new daily data for covid-19
    Given url "<EmptyURL>" in th payload
    When calling Post API and the response received
    Then the response code should be 400
    Examples:
      | EmptyURL |
      |          |
