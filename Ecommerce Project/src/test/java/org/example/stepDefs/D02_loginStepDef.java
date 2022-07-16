package org.example.stepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class D02_loginStepDef {
    LoginPage login=new LoginPage();
    @Given("user go to login page")
    public void navigate_to_login()
    {
        login.loginBtn().click();
    }
    @When("^user login with  \"(.*)\" and \"(.*)\"$")
    public void Login_with_username_Email_Password(String email,String password)
    {
        login.login_steps(email,password);
    }
    @And("user press on login button")
    public void press_Login()
    {
        login.LoginBtn().click();
    }

    @Then("user login to the system successfully")
    public void login_Successfully () {
        String expectedResult="https://demo.nopcommerce.com/";

        String actualResult=Hooks.driver.getCurrentUrl();
        SoftAssert soft=new SoftAssert();
        soft.assertEquals(actualResult,expectedResult);
        soft.assertTrue(login.my_Account().isDisplayed());
        soft.assertAll();
    }

    @Then("user could not login to the system")
    public void unSuccess_Login()
    {
        String expectedResult="Login was unsuccessful.";
        String actualResult=login.unSuccess_Message().getText();
        System.out.println(expectedResult);
        SoftAssert soft=new SoftAssert();
        soft.assertTrue(actualResult.contains(expectedResult));
        String actualColor=login.unSuccess_Message().getCssValue( "color");
        actualColor= Color.fromString(actualColor).asHex();
        System.out.println(actualColor);
        String expectedColor="#e4434b";
        System.out.println(expectedColor);
        soft.assertEquals(actualColor, expectedColor);
        soft.assertAll();
    }
}
