package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject{

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.className("radius");
    private By actualErrorMessageLocator = By.id("flash");

    public LoginPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Execute login
    public SecureAreaPage login(String username, String password){
        log.info("Trying to login as username " + username + " and password " + password);
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);
        return new SecureAreaPage(driver, log);
    }

    //Try to login
    public void tryToLogin(String username, String password){
        log.info("Trying to login as username " + username + " and password " + password);
        type(usernameLocator, username);
        type(passwordLocator, password);
        click(loginButtonLocator);
    }

    //Capture error message from Login
    public String getLoginErrorMessage(){
        return find(actualErrorMessageLocator).getText();
    }
}
