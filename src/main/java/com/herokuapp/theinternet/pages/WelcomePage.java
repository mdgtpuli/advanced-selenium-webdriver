package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject{

    private String welcomeURL = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");

    public WelcomePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Open Welcome page using URL
    public void openWelcomePage(){
        openURL(welcomeURL);
        log.info("Page open!");
    }

    //Open Login Page by clicking on Form Authentication link
    public LoginPage clickFormAuthenticationLink(){
        log.info("Open Login Page by clicking on Form Authentication link");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }
}
