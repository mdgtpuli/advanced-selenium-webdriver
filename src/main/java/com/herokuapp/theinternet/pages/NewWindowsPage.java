package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

@Getter
public class NewWindowsPage extends BasePageObject{


    public NewWindowsPage(WebDriver driver, Logger log){
        super(driver, log);
    }

}
