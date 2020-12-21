package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

@Getter
public class DropdownPage extends BasePageObject{

    private String dropdownPageURL ="http://the-internet.herokuapp.com/dropdown";
    private By dropdownLocator = By.id("dropdown");

    public DropdownPage (WebDriver driver, Logger log){
        super(driver, log);
    }

    //Select an option by value
    public void selectOptionByValue(String value){
        WebElement dropdownMenu = find(dropdownLocator);
        Select dropdown = new Select(dropdownMenu);

        //select the option using the string value
        dropdown.selectByValue(value);

        //select the option using the index

        //select the option using the displayed text

    }

    //Returns the selected option from the dropdown menu
    public String getSelectedOptionText(){
        WebElement dropdownMenu = find(dropdownLocator);
        Select dropdown = new Select(dropdownMenu);
        return dropdown.getFirstSelectedOption().getText();
    }
}
