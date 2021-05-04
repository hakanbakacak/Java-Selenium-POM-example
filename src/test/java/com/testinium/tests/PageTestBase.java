package com.testinium.tests;

import org.openqa.selenium.WebDriver;

public class PageTestBase {
    protected WebDriver driver = null;
    //protected PageObjectBase pageObject;

    public PageTestBase(WebDriver driver){
        this.driver = driver;
    }

    public PageTestBase(){

    }
}
