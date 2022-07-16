@smoke
Feature: F03_ChangeCurrencies| user could select currency and chang it from drop down list
  Scenario: user can select Euro Currency from the dropdown list on the top left of home page
    Given user select Euro Currency
    Then user verify Euro Symbol € is shown on the 4 products