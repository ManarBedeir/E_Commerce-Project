@smoke
  Feature: Home slider Feature

Scenario: user can click on first slider and goto https://demo.nopcommerce.com/nokia-lumia-1020
  When user clicks on slider "1"
  Then user redirected to the slider link "https://demo.nopcommerce.com/nokia-lumia-1020"

Scenario: user can click on first slider and goto https://demo.nopcommerce.com/nokia-lumia-1020
  When user clicks on slider "2"
  Then user redirected to the slider link "https://demo.nopcommerce.com/iphone-6"
