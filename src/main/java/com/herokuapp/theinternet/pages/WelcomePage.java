package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject{

    private String welcomeURL = "http://the-internet.herokuapp.com/";
    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By javaScriptAlertsLinkLocator = By.linkText("JavaScript Alerts");

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


    //Open Checkboxes page by clicking on the link
    public CheckboxesPage openCheckboxesPage(){
        log.info("Opening checkboxes page");
        driver.findElement(checkboxesLinkLocator).click();
        return new CheckboxesPage(driver, log);
    }

    //Open Dropdown page by clicking on the link
    public DropdownPage openDropdownPage(){
        log.info("Opening dropdown page");
        driver.findElement(dropdownLinkLocator).click();
        return new DropdownPage(driver, log);
    }

    //Open JavaScript Alerts page by clicking on the link
    public AlertsPage openAlertPage(){
        log.info("Opening Alerts page");
        driver.findElement(javaScriptAlertsLinkLocator).click();
        return new AlertsPage(driver, log);
    }
}
