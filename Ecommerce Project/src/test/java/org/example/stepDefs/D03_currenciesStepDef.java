package org.example.stepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.example.pages.HomePage;

public class D03_currenciesStepDef {
    HomePage home=new HomePage();

    @Given("user select Euro Currency")
    public void select_EuroCurrency()
    {
        home.EuroCurrency().click();

    }
    @Then("user verify Euro Symbol € is shown on the 4 products")
    public void verify_Euro_Symbol()
    {

        home.euro_symbol_in_Products();

    }
}
