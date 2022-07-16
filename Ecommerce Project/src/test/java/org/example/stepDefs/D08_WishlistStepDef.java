package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class D08_WishlistStepDef {
    HomePage homePage=new HomePage();
    @When("^user clicks wish button for \"(.*)\"$")
    public void Click_product(String productName)
    {
        WebElement wishBtn = homePage.get_Add_toWishList_Btn(productName);
        new Actions(Hooks.driver).scrollToElement(wishBtn).perform();
       homePage.get_Add_toWishList_Btn(productName).click();
        System.out.println("clicked");

    }
    @Then("^success message \"(.*)\" with green background color is displayed$")
    public void verify_successMessage_WithGreenColor(String successMessage) throws InterruptedException {
      Thread.sleep(2000);
       String actual_message=homePage.get_SuccessMessage().getText();
       String expected_message=successMessage;
        WebElement firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.visibilityOf(homePage.get_SuccessMessage()));
       Thread.sleep(2000);
       SoftAssert soft=new SoftAssert();
       soft.assertEquals(actual_message,expected_message);
       String back_GroundColor=homePage.get_backGround_Color().getCssValue("background-color");
       soft.assertEquals(back_GroundColor,"rgba(75, 176, 122, 1)");
       soft.assertAll();
    }
    @And("wait until success message disappear")
    public void wait_until_MessageDisappear()
    {
        Boolean firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.invisibilityOf(homePage.get_SuccessMessage()));
    }
    @Then("^click on Wishlist Tab on the top of the page$")
    public void click_wishBtn_onTop_onTop_ofPage() throws InterruptedException {

        new Actions(Hooks.driver).scrollToElement(homePage.get_WishBtn_list()).perform();
        Thread.sleep(4000);
        homePage.get_WishBtn_list().click();
        String qty=homePage.get_Qty_Element().getAttribute("value");
        int qty_integer = Integer.parseInt(qty);
        System.out.println(qty);
        Assert.assertTrue(qty_integer>0);

    }
}
