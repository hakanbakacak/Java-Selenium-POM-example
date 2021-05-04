package com.testinium.tests;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertNotEquals;

import java.io.IOException;
import java.util.Properties;

import com.testinium.pages.LoginPageObject;

public class LoginPageTest {
    private static String pageUrl = "https://www.gittigidiyor.com/uye-girisi";
    private static LoginPageObject loginPageObject;
    private static WebDriver driver = null; 

    public LoginPageTest(){
        //super(driver);
       
    }
    

    @BeforeClass
    public static void initializeClass(){
        driver = new FirefoxDriver();
        driver.get(pageUrl);
        loginPageObject = new LoginPageObject(driver);
        
    }

    @Before
    public void openLoginPage(){
        driver.get(pageUrl);
    }

    /*@Test
    public void isPageOpen(){
        
        String expectedTitle = "Üye Girişi - GittiGidiyor";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }*/

    @Test
    public void loginTest(){
       
        // String username = System.getProperty("login.data.username");
        // String password = System.getProperty("login.data.password");
        String username = "username";
        String password = "password";
        loginPageObject.login(username, password);
        String currentURL = driver.getCurrentUrl();
        
        assertNotEquals(currentURL, pageUrl);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
