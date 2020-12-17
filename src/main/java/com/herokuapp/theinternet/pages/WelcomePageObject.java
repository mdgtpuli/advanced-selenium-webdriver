package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePageObject extends BasePageObject{

    private String URL = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePageObject(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Open Welcome page using URL
    public void openPage(){
        log.info("Opening page "+ URL);
        openURL(URL);
        log.info("Page open!");
    }

    //Open Login Page by clicking on Form Authentication link
    public LoginPage clickFormAuthenticationLink(){
        log.info("Open Login Page by clicking on Form Authentication link");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }
}
