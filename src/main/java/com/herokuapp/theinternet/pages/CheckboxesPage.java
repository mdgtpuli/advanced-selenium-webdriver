package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

@Getter
public class CheckboxesPage extends BasePageObject {

    private String checkboxesURL = "http://the-internet.herokuapp.com/checkboxes";
    private By checkboxesLocator = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver, Logger log) {

        super(driver, log);
    }

    private List<WebElement> findAllCheckboxes(){
        return findAll(checkboxesLocator);
    }

    //Find all checkboxes in the page and select them
    public void selectAllCheckboxes() {
        List<WebElement> checkboxes = findAllCheckboxes();
        for (WebElement checkbox : checkboxes) {
            if (!checkbox.isSelected()) {
                checkbox.click();
            }
        }
    }

    //Return true if all checkboxes are selected
    public boolean areAllCheckboxesSelected(){
        List<WebElement> checkboxes = findAllCheckboxes();
        for(WebElement checkbox: checkboxes) {
            if (!checkbox.isSelected()) {
                return false;
            }
        }
        return true;

    }


}
