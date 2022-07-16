@smoke
  Feature: user should can Add the product to his wish list
Scenario: add the product to wishlist successfully
  When user clicks wish button for "HTC One M8 Android L 5.0 Lollipop"
  Then success message "The product has been added to your wishlist" with green background color is displayed

Scenario: add the product to wishlist successfully and wait until success message disappear
then click on wish list button on top of the page
  When user clicks wish button for "HTC One M8 Android L 5.0 Lollipop"
  And  wait until success message disappear
  Then click on Wishlist Tab on the top of the page