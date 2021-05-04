package com.testinium.pages;


import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.interactions.Actions;

public class SearchResultPageObject extends PageObjectBase{
    By xpathSearchPageNumButtons = By.xpath("//div[@class='pager pt30 hidden-m gg-d-24']//li//a");
    By xpathProducts = By.xpath("/html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[3]/div[2]/ul[1]/li");//old xpath /html[1]/body[1]/div[5]/div[1]/div[1]/div[2]/div[4]/div[2]/ul[1]/li                        
    By xpathProductContainer = By.xpath("//li[@id='product_id_532779150']");
    By xpathAddBasketButton = By.xpath("//button[@class='gg-ui-button gg-ui-btn-primary'][contains(text(),'Sepete Ekle')]");
    //String apathBasketButton = "//div[@id='item-info-block-687391797']//div[contains(@class,'product-info-con clearfix')]//div[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 pl0 pr0 product-info-details']//div[@class='gg-w-24 gg-d-24 gg-t-24 hidden-m hidden-t padding-none buy-now-button']//button[@class='gg-ui-button gg-ui-btn-primary'][contains(text(),'Sepete Ekle')]"; 
    public SearchResultPageObject(WebDriver driver){
        super(driver);
    }
    
    public void changePage(int pageNum){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpathSearchPageNumButtons));
        List<WebElement> pageButtons = getPageNumButtons();
        Point pageButtonLocation = pageButtons.get(2).getLocation();
        
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+pageButtonLocation.getY()+30+")","");
        pageButtons.get(1).click();
    }

    public List<WebElement> getPageNumButtons(){
        return driver.findElements(xpathSearchPageNumButtons);
    }

    public List<WebElement> getProducts(){
        return driver.findElements(xpathProducts);
    }

    public String getProductPrice(WebElement product){
        return product.findElement(By.className("extra-price")).getText();
        
    }
    public String getProductId(WebElement product){
        return product.getAttribute("id");
    }
    public void addBasket(WebElement product) throws InterruptedException{
        //Actions actionProvider = new Actions(driver);
        // product = driver.findElement(By.xpath("//li[@id='"+product.getAttribute("id")+"']"));
       // actionProvider.moveToElement(product).build().perform(); 
        //Thread.sleep(300);
        
        /*Point productLocation = product.getLocation();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,"+productLocation.getY()+30+")","");*/
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        /*Actions actionProvider = new Actions(driver);
        actionProvider.moveToElement(product).build().perform(); 
        Thread.sleep(300);*/
        WebElement button = product.findElement(By.xpath("//div[@id='item-info-block-"+product.getAttribute("product-id")+"']//div[contains(@class,'product-info-con clearfix')]//div[@class='gg-w-24 gg-d-24 gg-t-24 gg-m-24 pl0 pr0 product-info-details']//div[@class='gg-w-24 gg-d-24 gg-t-24 hidden-m hidden-t padding-none buy-now-button']//button[@class='gg-ui-button gg-ui-btn-primary'][contains(text(),'Sepete Ekle')]"));
        button.click();
    }
}

        
