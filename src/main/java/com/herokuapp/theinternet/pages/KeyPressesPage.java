package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;

public class KeyPressesPage extends BasePageObject {
    String KeyPressesURL= "http://the-internet.herokuapp.com/key_presses";
    By bodyLocator = By.tagName("body");
    By resultLocator = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Open Key presses page
    public void openKeyPressesPage(){
        log.info("Opening Key Presses page");
         driver.get(KeyPressesURL);
         log.info("Page open!");
    }

    //Press a key using locator
    public void pressKey(Keys key){
        pressKey(bodyLocator,key);
    }

    //Get result message from body
    public String getResultMessage(){
        String resultText = find(resultLocator).getText();
        log.info("Result text is: "+ resultText);
        return resultText;
    }


}
