package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class registeration {
    public WebElement registerBtn()
    {
        WebElement registerBtn= Hooks.driver.findElement(By.cssSelector("a[href='/register?returnUrl=%2F'"));
        //WebElement regBtn=Hooks.driver.findElement(By.className("ico-register"));
        return registerBtn;
    }

    public WebElement genderSelector(String genderValue)
    {
        return Hooks.driver.findElement(By.xpath("//label[text()='"+genderValue+"']"));


    }
    public WebElement FirstName(){
        return Hooks.driver.findElement(By.xpath("//input[@id='FirstName']"));
    }
    public WebElement LastName()
    {
        return Hooks.driver.findElement(By.xpath("//input[@id='LastName']"));
    }


    public  void enteringNames(String firstname, String lasName)
    {
        FirstName().clear();
        FirstName().sendKeys(firstname);
        LastName().clear();
        LastName().sendKeys(lasName);
    }
    public void  Day()
    {
        WebElement day_dropdown=Hooks.driver.findElement(By.xpath("//select[@name='DateOfBirthDay']"));
        Select day=new Select(day_dropdown);
        day.selectByVisibleText("1");
    }
    public void Month()
    {
        WebElement month_dropdown=Hooks.driver.findElement(By.xpath("//select[@name='DateOfBirthMonth']"));
        Select month=new Select(month_dropdown);
        month.selectByVisibleText("April");
    }
    public void Year()
    {
        WebElement year_dropdown=Hooks.driver.findElement(By.xpath("//select[@name='DateOfBirthYear']"));
        Select year=new Select(year_dropdown);
        year.selectByVisibleText("1990");
    }
    public WebElement Email()
    {
        return Hooks.driver.findElement(By.xpath("//input[@id='Email']"));
    }
    public WebElement Password()
    {
        return Hooks.driver.findElement(By.xpath("//input[@id='Password']"));
    }
    public WebElement confirmPassword()
    {
        return Hooks.driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
    }
    public WebElement RegisterBtn()
    {
        return Hooks.driver.findElement(By.xpath("//button[@id='register-button']"));
    }
    public WebElement success_Message()
    {
        return Hooks.driver.findElement(By.xpath("//div[contains(text(),'Your registration completed')]"));
    }
    public WebElement back_GroundColor()
    {
        return Hooks.driver.findElement(By.className("page-body"));
    }
}
