package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.registeration;
import org.testng.asserts.SoftAssert;

public class D01_registerStepDef {
    registeration reg=new registeration();
    @Given("user go to register page")
    public void goRegisterPage()
    {

        reg.registerBtn().click();

    }
    @When("user select gender type")
    public void select_Gender_Type()
    {
        if(!(reg.genderSelector("Female").isSelected()))
        {
            reg.genderSelector("Female").click();
        }
    }
    @And("^user enter first name \"(.*)\" and last name \"(.*)\"$")
    public void enter_first_lastName(String firstName,String lastName )
    {
        reg.enteringNames(firstName,lastName);
    }
    @And("user enter date of birth")
    public void SelectDateOfBirth()
    {
        reg.Day();
        reg.Month();
        reg.Year();
    }
    @And("^user enter email \"(.*)\" field$")
    public void enter_Email(String mail)
    {
        reg.Email().sendKeys(mail);
    }
    @And("^user fills Password fields \"(.*)\" \"(.*)\"$")
    public void fill_password_Fields(String password,String confirmPassword)
    {
        reg.Password().sendKeys(password);
        reg.confirmPassword().sendKeys(confirmPassword);
    }
    @And("user clicks on register button")
    public void click_Register()
    {
        reg.RegisterBtn().click();
    }
    @Then("success message is displayed")
    public void success_message()
    {

        String expectedResult="Your registration completed";
        String actualResult=reg.success_Message().getText();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualResult,expectedResult);

        soft.assertEquals(reg.back_GroundColor().getCssValue( "color"),"rgba(119, 119, 119, 1)");
        soft.assertAll();
    }
}
