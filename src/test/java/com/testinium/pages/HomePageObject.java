package com.testinium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePageObject{
    WebDriver driver = null;
    By xpathLoginDiv = By.xpath("/html[1]/body[1]/div[1]/header[1]/div[3]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]");
    By xpathLoginButton = By.xpath("//a[@class='qjixn8-0 sc-1bydi5r-0 kNKwwK']");

    public HomePageObject(WebDriver driver){
        this.driver = driver;
    }

    public void clickLoginButton() throws InterruptedException{

        WebElement loginDiv = driver.findElement(this.xpathLoginDiv);
        Actions actionProvider = new Actions(driver);
        // Perform click-and-hold action on the element
        actionProvider.moveToElement(loginDiv).build().perform(); //clickAndHold(element).build().perform();
        Thread.sleep(300);
        WebElement loginButton = driver.findElement(xpathLoginButton);
        loginButton.click();
    }

}
