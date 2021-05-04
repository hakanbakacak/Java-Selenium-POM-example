package com.testinium;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.List;
import java.util.Random;

import com.testinium.pages.HomePageObject;
import com.testinium.pages.LoginPageObject;
import com.testinium.pages.SearchResultPageObject;
import com.testinium.tests.HomePageTest;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginAndAddBasketTest {
    private static String pageUrl = "https://www.gittigidiyor.com/";
    private static WebDriver driver = null;
    private HomePageObject homePageObject = null;
    private LoginPageObject loginPageObject = null;
    private SearchResultPageObject searchResultPageObject = null;
    //private static Logger logger; 
    
    @BeforeClass
    public static void initializeWebdriver(){
        driver = new FirefoxDriver();
    }
    @Before
    public void openHomePage(){
        driver.get(pageUrl);
    }

    @Test
    public void LoginAndAddBasketTest() throws InterruptedException{
        
        homePageObject = new HomePageObject(driver);
        assertEquals("https://www.gittigidiyor.com/", driver.getCurrentUrl());
        

        homePageObject.clickLoginButton();
        assertEquals("https://www.gittigidiyor.com/uye-girisi", driver.getCurrentUrl());


        loginPageObject = new LoginPageObject(driver);
        loginPageObject.login("username", "password");
        assertNotEquals(driver.getCurrentUrl(), pageUrl+"uye-girisi");
        
        //driver.get(pageUrl);

        homePageObject.searchKeyword("bilgisayar");
        searchResultPageObject = new SearchResultPageObject(driver);
        //Thread.sleep(3000);
        
        searchResultPageObject.changePage(2);

        List<WebElement> products = searchResultPageObject.getProducts();
        Random rand = new Random();
        WebElement randomProduct = products.get(rand.nextInt(products.size()));
        String priceInSearchPage = searchResultPageObject.getProductPrice(randomProduct);
        System.out.println(randomProduct.getAttribute("id"));
        searchResultPageObject.addBasket(randomProduct);
        System.out.println(priceInSearchPage);
    }



    
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
