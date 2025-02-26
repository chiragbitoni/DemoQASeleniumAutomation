package com.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {
    public static WebDriver driver;

    public void setDriver(WebDriver driver){
        BasePage.driver = driver;
    }
    public WebDriver getDriver(){
        return driver;
    }
    public WebElement find(By locator){
        return driver.findElement(locator);
    }
    public List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
    public void setText(By locator, String text){
        find(locator).clear();
        find(locator).sendKeys(text);
    }
    public void click(By locator){
        find(locator).click();
    }
    public static void delay(int milliseconds){
        try{
            Thread.sleep(milliseconds);
        }catch (InterruptedException exc){
            exc.printStackTrace();
        }
    }
}
