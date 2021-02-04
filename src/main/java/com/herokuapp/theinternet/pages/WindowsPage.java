package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class WindowsPage extends BasePageObject{

    private By clickHereLocator = By.linkText("Click Here");


    public WindowsPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Click the "Click Here" button and switch to new page
    public void clickHereButton(){
        log.info("Clicking on New Window link");
        find(clickHereLocator).click();
    }

    //Find page New Window and switch to it -> returns NewWindowsPage
    public NewWindowsPage switchToNewWindowsPage(){
        log.info("Looking for New Window page");
        switchToWindowWithTitle("New Window");
        return new NewWindowsPage(driver,log);
    }

}
