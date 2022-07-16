package org.example.pages;

import org.example.stepDefs.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {
    public String LinkText="";
    public WebElement EuroCurrency()
    {
        int size = Hooks.driver.findElements(By.xpath("//select[@id='customerCurrency']")).size();
        for (int i=0; i < size; i++)
        {
            String currency_Value= Hooks.driver.findElements(By.xpath("//select[@id='customerCurrency']")).get(i).getText();


        }
        return Hooks.driver.findElement(By.xpath("//option[text()='Euro']"));
    }

    public void euro_symbol_in_Products() {

        WebElement price_span = Hooks.driver.findElement(By.xpath("//span[@class='price actual-price']"));
        new Actions(Hooks.driver).scrollToElement(price_span).perform();
        WebElement firstResult = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='price actual-price']")));


        for(int i=0;i<4;i++)
        {
            String list=Hooks.driver.findElements(By.xpath("//span[@class='price actual-price']")).get(i).getText();
            System.out.println(list);
            Assert.assertTrue(list.contains("€"));


        }



    }

    public WebElement searchField()
    {
        return Hooks.driver.findElement(By.id("small-searchterms"));
    }
    public WebElement searchBtn()
    {
        return Hooks.driver.findElement(By.xpath("//button[@class='button-1 search-box-button']"));
    }
    public void search_Result_Count(String name)
    {
        WebElement searchResul = Hooks.driver.findElement(By.xpath("//div[@class='search-results']"));
        new Actions(Hooks.driver).scrollToElement(searchResul).perform();
        SoftAssert soft=new SoftAssert();
        int search_Count=Hooks.driver.findElements(By.xpath("//h2[@class='product-title']")).size();
        System.out.println("Search count is " +search_Count);
        for (int i=0;i<search_Count;i++)
        {
            String search_Result=Hooks.driver.findElements(By.xpath("//h2[@class='product-title']")).get(i).getText().toLowerCase();
            System.out.println("Search result is "+i+" : "+search_Result);
            System.out.println("Product Name "+i+" : "+name);
            soft.assertTrue(search_Result.contains(name));
        }
    }
    public WebElement sku_product_in_Search()
    {
        return Hooks.driver.findElement(By.xpath("//h2[@class='product-title']//a"));
    }
    public String Sku_Title()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class='sku']//span[@class='value']")).getText();
    }
    public void select_Random_Elements() throws InterruptedException {
        Actions actions = new Actions(Hooks.driver);
        List<WebElement> MainMenuList = Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']/li"));
        int MainMenuCount = MainMenuList.size();
        int min = 0;
        int max = MainMenuCount-1;
        int selectedCategory =  (int)Math.floor(Math.random()*(max-min+1)+min);
        actions.moveToElement(MainMenuList.get(selectedCategory)).perform();

        Thread.sleep(4000);
        List<WebElement> SubMenuLinks = Hooks.driver.findElements(By.xpath("//ul[@class='top-menu notmobile']//ul//li"));
        String selectedSubCategory;
        if (checkSubMenu(SubMenuLinks)) {
            ArrayList<WebElement> sub_links = createSubMenuList(SubMenuLinks);
            System.out.println("There's subMenu");
            int SubMenuCount = sub_links.size();
            int SubMenuMin = 0;
            int SubMenuMax = SubMenuCount-1;
            int selectedSubItem =  (int)Math.floor(Math.random()*(SubMenuMax-SubMenuMin+1)+SubMenuMin);
            selectedSubCategory = SubMenuLinks.get(selectedSubItem).getText();
            LinkText=selectedSubCategory;
            sub_links.get(selectedSubItem).click();
        } else {
            System.out.println("No submenu");
            selectedSubCategory=MainMenuList.get(selectedCategory).getText();
            MainMenuList.get(selectedCategory).click();
        }

        Thread.sleep(4000);

    }

    public boolean checkSubMenu(List<WebElement> subMenuList) {
        for (int i = 0; i < subMenuList.size(); i++) {
            if (subMenuList.get(i).getText() != "") {
                return true;
            }
        }
        return false;
    }

    public ArrayList<WebElement> createSubMenuList(List<WebElement> subMenuList) {
        ArrayList<WebElement> sub_links = new ArrayList<WebElement>();
        for (int i = 0; i < subMenuList.size(); i++) {
            if (subMenuList.get(i).getText() != "") {
                sub_links.add(subMenuList.get(i));
            }
        }
        return sub_links;
    }
    public String pageTitle_text()
    {
        Hooks.driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        System.out.println(Hooks.driver.getTitle().toLowerCase().trim());
        return Hooks.driver.getTitle();
    }
   public WebElement get_slider(String sliderNum)
   {
       Hooks.driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
       return Hooks.driver.findElement(By.partialLinkText(sliderNum));
       //return Hooks.driver.findElement(By.xpath("//div[@class='nivoSlider']//a[@class='nivo-imageLink']["+sliderNum+"]"));
   }

   public WebElement get_socialAccount_Element(String socialAccount)
   {
       return Hooks.driver.findElement(By.cssSelector("li[class='"+socialAccount+"']"));
   }
   public WebElement get_backGround_Color()
   {
       return Hooks.driver.findElement(By.xpath("//div[@class='bar-notification success']"));
   }
   public WebElement get_Add_toWishList_Btn(String productName)
   {
       //return Hooks.driver.findElement(By.id("add-to-wishlist-button-18"));
       return Hooks.driver.findElement(By.xpath("//div[@class='details']/h2/a[text()='"+productName+"']/ancestor::div[1]/child::div[3]/child::div[2]//button[@class='button-2 add-to-wishlist-button']"));
   }
   public WebElement get_SuccessMessage()
   {
       return Hooks.driver.findElement(By.cssSelector("p[class='content']"));
   }
   public WebElement get_WishBtn_list()
   {
       return Hooks.driver.findElement(By.xpath("//a[@class='ico-wishlist']"));
   }
    public WebElement get_Qty_Element()
    {
        return Hooks.driver.findElement(By.xpath("//input[@class='qty-input']"));
    }

}
