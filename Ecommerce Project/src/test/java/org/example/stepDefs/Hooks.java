package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver=null;
    @Before
    public static void open_browser()
    {
        //1- define bridge
        WebDriverManager.chromedriver().setup();
        //2-create new object
        driver=new ChromeDriver();
        //3-configuration
        //3.1 Maximize screen
        driver.manage().window().maximize();;

        //3.2 implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3.3 navigate to website
        driver.navigate().to("https://demo.nopcommerce.com/");

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}
