package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

public class D05_hoverCategoriesStepDef {

    HomePage home=new HomePage();
    @When("user hoover on mainCategory and click one randomly,then click random SubCategory and click on its text")
    public void Select_Randomly_Categories() throws InterruptedException {
        home.select_Random_Elements();
    }
    @Then("user get title text then Assert that the sub-category title is equal or contains the one you get it while selecting random sub-category")
    public void verify_TitleContains_RandomSelected_Category()
    {
        String actual_PageTitle=home.pageTitle_text().toLowerCase().trim();
        System.out.println("Actual Page title : "+actual_PageTitle);
        System.out.println("Selected Menu Item : "+home.LinkText.toLowerCase().trim());
        Assert.assertTrue(actual_PageTitle.contains(home.LinkText.toLowerCase().trim()));
    }
}
