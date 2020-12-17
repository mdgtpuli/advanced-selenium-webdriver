package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


@Getter
public class SecureAreaPage extends BasePageObject{

    private String secureAreaURL = "http://the-internet.herokuapp.com/secure";
    private By logoutButtonLocator = By.xpath("//*[@id=\"content\"]/div/a/i");
    private By successfulLoginMessageLocator = By.id("flash");

    public SecureAreaPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    public Boolean islogoutButtonVisible (){
        return isElementVisible(logoutButtonLocator);

    }

    public String getSuccessfulLoginMessageLocator(){
        return find(successfulLoginMessageLocator).getText();
    }
}
