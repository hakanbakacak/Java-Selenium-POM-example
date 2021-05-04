package com.testinium.pages;

import org.openqa.selenium.WebDriver;


public abstract class PageObjectBase {
    
    WebDriver driver = null;
    
    
    public PageObjectBase(WebDriver driver){
        this.driver = driver;
    }


    protected void finalize(){
        if(driver != null){
            driver.quit();
        }
    }
}
