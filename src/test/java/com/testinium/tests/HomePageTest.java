package com.testinium.tests;

import static org.junit.Assert.assertEquals;

import com.testinium.pages.HomePageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class HomePageTest {
    private static String pageUrl = "https://www.gittigidiyor.com/";
    private static WebDriver driver = null;
    private HomePageObject homePageObject;
    //private static Logger logger; 
    
    @BeforeClass
    public static void initializeWebdriver(){
        driver = new FirefoxDriver();
        /* System.setProperty("log4j.configurationFile","src/test/resources/log4j2.properties");
        logger = LogManager.getLogger(HomePageTest.class);
        
        logger.info("This is information message"); */
    }
    @Before
    public void openHomePage(){
        driver.get(pageUrl);
    }

    @Test
    public void isPageOpen(){
        
        String expectedTitle = "GittiGidiyor - Türkiye'nin Öncü Alışveriş Sitesi";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void isLoginButtonNavigateToLoginPage() throws InterruptedException{
        homePageObject = new HomePageObject(driver);
        homePageObject.clickLoginButton();
        String expectedURL = "https://www.gittigidiyor.com/uye-girisi";
        String actualURL =  driver.getCurrentUrl();
        assertEquals(expectedURL, actualURL);
        
    }

    
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    

    /* public static void main(String[] args) throws InterruptedException {
       
        Logger logger = LogManager.getLogger(HomePageTest.class);
        
        //openHomePage();
    
        
        System.out.println("\n\nHello\n\n");
        logger.info("This is information message");
        logger.error("This is an error message");   
        logger.warn("This is warning message");
        logger.fatal("This is fatal message");  

        System.out.println("\nCompleted");
    }

    public static void openHomePage() throws InterruptedException{

        HomePageObject homePageObj = new HomePageObject(driver);
        homePageObj.clickLoginButton();
        driver.quit();
        
    } */
}
 