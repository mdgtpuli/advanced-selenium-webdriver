package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log){
        this.driver= driver;
        this.log= log;
    }

    //Open page with given URL
    protected void openURL(String URL){
        log.info("Opening URL " + URL);
        driver.get(URL);

    }

    //Find element by locator
    protected WebElement find(By locator){
        return driver.findElement(locator);
    }

    //Find several elements by locator
    protected List<WebElement> findAll(By locator){
        return driver.findElements(locator);
    }

    //Wait for a specific condition to appear
    protected void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds){
        timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds: 30;
        WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
        wait.until(condition);
    }

    //Wait for the visibility of an Element given a specific amount of seconds
    protected void waitForVisibility(By locator, Integer... timeOutInSeconds){
        int attempts = 0;
        while (attempts < 2){
            try{
                waitFor(ExpectedConditions.visibilityOfElementLocated(locator),
                        timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null);
                break;
            }catch(StaleElementReferenceException e){

            }
            attempts++;
        }
    }

    //Click element when it is visible
    protected void click(By locator){
    waitForVisibility(locator, 5);
    find(locator).click();
    }

    //Type text to a given locator
    protected void type( By locator, String text){
        waitForVisibility(locator, 5);
        find(locator).sendKeys(text);
    }

    //Read page URL
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    //Report if element is visible
    public Boolean isElementVisible(By locator){
        return driver.findElement(locator) != null;
    }

}
