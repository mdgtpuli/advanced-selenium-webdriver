package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class AlertsPage extends BasePageObject{

    private By jsAlertLocator = By.xpath("//button[text()='Click for JS Alert']");
    private By jsConfirmLocator = By.xpath("//button[text()='Click for JS Confirm']");
    private By jsPromptLocator = By.xpath("//button[text()='Click for JS Prompt']");
    private String alertsPageURL = "http://the-internet.herokuapp.com/javascript_alerts";
    private By resultLocator = By.id("result");

    public AlertsPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Click on Click for JS Alert button
    public void clickJSAlertButton(){
        find(jsAlertLocator).click();

    }

    //Click on Click for JS Confirm button
    public void clickJSConfirmButton(){
        find(jsConfirmLocator).click();
    }

    //Click on Click for JS Prompt button
    public void clickJSPromptButton(){
        find(jsPromptLocator).click();
    }

    //Get result message
    public String getResultMessage(){
        return find(resultLocator).getText();
    }
}
