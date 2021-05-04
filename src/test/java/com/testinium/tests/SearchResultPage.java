package com.testinium.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import com.testinium.pages.SearchResultPageObject;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SearchResultPage {
    private static String pageUrl = "https://www.gittigidiyor.com/arama/?k=bilgisayar";
    private static SearchResultPageObject searchResultPageObject;
    private static WebDriver driver = null; 

    @BeforeClass
    public static void initializeClass(){
        driver = new FirefoxDriver();
        driver.get(pageUrl);
        searchResultPageObject = new SearchResultPageObject(driver);
    }

    @Before
    public void openSearchResultPage(){
        driver.get(pageUrl);
    }

    @Test
    public void isPageOpen(){
        
        String expectedTitle = "Bilgisayar - GittiGidiyor";
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void getPageNumButtonsTest(){
        int pageNumButtonCount = searchResultPageObject.getPageNumButtons().size();
        assertNotEquals(0, pageNumButtonCount);
    }

    @Test
    public void changePageTest(){
        searchResultPageObject.changePage(2);
        String expectedClassAttribute = "current";
        String actualClassAttribute = ""; 
        
        for (WebElement pageButton : searchResultPageObject.getPageNumButtons()) {    
            if(pageButton.getText().equals("2")){
                System.out.println(pageButton.getText());
                actualClassAttribute = pageButton.getAttribute("class");
            }
        }
        assertEquals(expectedClassAttribute, actualClassAttribute);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
