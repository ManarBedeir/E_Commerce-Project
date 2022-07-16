@smoke
Feature:Hover on Categories
  As a User I can hover on different categories in home page
  and select any record of selected category
  Scenario: hoover on random category and click on random item in it
    When user hoover on mainCategory and click one randomly,then click random SubCategory and click on its text
    Then   user get title text then Assert that the sub-category title is equal or contains the one you get it while selecting random sub-category