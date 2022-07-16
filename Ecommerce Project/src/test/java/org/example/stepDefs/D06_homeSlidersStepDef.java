package org.example.stepDefs;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class D06_homeSlidersStepDef {
    HomePage homePage=new HomePage();
    @When("^user clicks on slider \"(.*)\"$")
    public void click_nokia_Slider(String number)
    {
        homePage.get_slider(number).click();
    }
    @Then("^user redirected to the slider link \"(.*)\"$")
    public void verify_sliderLink_opened(String link){
       String actualLink= Hooks.driver.getCurrentUrl();
       String expectedLink=link;
        Boolean firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains(expectedLink));
        Assert.assertEquals(actualLink,expectedLink);
    }

}
