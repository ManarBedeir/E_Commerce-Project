package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
    public WebElement loginBtn() {

        return Hooks.driver.findElement(By.xpath("//a[@class='ico-login']"));
    }
    public WebElement Email()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }
    public WebElement Password()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }
    public void login_steps(String email, String password)
    {
        Email().clear();
        Email().sendKeys(email);
        Password().clear();
        Password().sendKeys(password);
    }
    public WebElement LoginBtn()
    {
        return Hooks.driver.findElement(By.xpath("//button[@class='button-1 login-button']"));
    }
    public WebElement my_Account()
    {
        return  Hooks.driver.findElement(By.xpath("//a[@class='ico-account']"));
    }
    public WebElement unSuccess_Message()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class='message-error validation-summary-errors']"));
    }
}
