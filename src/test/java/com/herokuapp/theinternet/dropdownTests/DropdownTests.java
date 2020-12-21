package com.herokuapp.theinternet.dropdownTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DropdownPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropdownTests extends TestUtilities {

    @Test
    public void selectOptionTwoTest(){

        log.info("Starting test Select option two");

        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Click on Dropdown link
        DropdownPage dropdownPage = welcomePage.openDropdownPage();

        //Select Option 2
        dropdownPage.selectOptionByValue("2");

        //VERIFICATIONS
        SoftAssert soft = new SoftAssert();

        //Verify the new URL for dropdown page
        soft.assertEquals(dropdownPage.getCurrentUrl(), dropdownPage.getDropdownPageURL());

        //Select Option 2 is selected
        soft.assertEquals("Option 2", dropdownPage.getSelectedOptionText());

        soft.assertAll();

        log.info("Test Select option two completed!");
    }
}
