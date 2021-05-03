package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends PageObjectBase{
    //WebDriver driver = null;
    By xpathUsernameTextbox = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[2]/input[1]");
    By xpathPasswordTextbox = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[2]/div[1]/div[2]/input[1]");
    By xpathLoginButton = By.xpath("/html[1]/body[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/div[2]/div[1]/input[13]");

    public LoginPageObject(WebDriver driver){
        super(driver);
    }

    public void enterUsername(String username){
        driver.findElement(xpathUsernameTextbox).sendKeys(username);
    }

    public void enterPassword(String password){
        driver.findElement(xpathPasswordTextbox).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(xpathLoginButton).click();
    }

    public void login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
