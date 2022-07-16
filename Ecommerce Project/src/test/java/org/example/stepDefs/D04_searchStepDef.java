package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D04_searchStepDef {
    HomePage home=new HomePage();
    @Given("^I click on search field$")
    public void click_SearchField()
    {
        home.searchField().click();
    }
    @When("^I Enter productName as \"([^\"]*)\"$")
    public void Enter_productName(String productName)
    {
        home.searchField().sendKeys(productName);
    }
    @And("^I click on search button$")
    public void click_SearchBtn()
    {
        home.searchBtn().click();
    }
    @Then("^I should verify the Count number of search results and search result contains \"([^\"]*)\"$")
    public void success_Search(String name)
    {
        String ExpectedLink="https://demo.nopcommerce.com/search?q="+name;
        String actualLink=Hooks.driver.getCurrentUrl();
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actualLink.contains(ExpectedLink));
        home.search_Result_Count(name);
        soft.assertAll();
    }
    @And("^I click on product in search$")
    public void click_the_product()
    {
        System.out.println(home.sku_product_in_Search().getText());
        home.sku_product_in_Search().click();
    }
    @Then("I should verify the product contains \"([^\"]*)\"$")
    public void verify_product_contain_Sku(String expected)
    {
        String Actual_title=home.Sku_Title();
        System.out.println(Actual_title);
        String expectedTitle=expected;
        Assert.assertTrue(Actual_title.contains(expectedTitle));
    }
}
