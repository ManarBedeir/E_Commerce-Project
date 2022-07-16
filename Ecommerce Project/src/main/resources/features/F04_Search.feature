@smoke

Feature: Search
  As a user
  I want to search for a product

  Scenario Outline: search with Product Name
    Given I click on search field
    When I Enter productName as "<productName>"
    And I click on search button
    Then I should verify the Count number of search results and search result contains "<productName>"

    Examples:
      |productName|
      |book|
      |laptop|
      |nike|


  Scenario Outline: search with  SKU
    Given I click on search field
    When I Enter productName as "<sku>"
    And I click on search button
    And I click on product in search
    Then I should verify the product contains "<sku>"
    Examples:
      |sku|
      |SCI_FAITH|
      |APPLE_CAM|
      |SF_PRO_11|