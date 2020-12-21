package com.herokuapp.theinternet.checkboxTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.CheckboxesPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckboxTests extends TestUtilities {

    @Test
    public void openCheckboxesPageTest(){

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.openCheckboxesPage();

        //Verify that the URL is the expected one
        Assert.assertEquals(checkboxesPage.getCurrentUrl(), checkboxesPage.getCheckboxesURL(),
                "Checkboxes page URL is not the expected URL");


    }@Test
    public void selectingTwoCheckBoxesTest(){

        //open main page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Click on checkboxes link
        CheckboxesPage checkboxesPage = welcomePage.openCheckboxesPage();

        //Select all checkboxes
        checkboxesPage.selectAllCheckboxes();

        //Verify that all checkboxes are checked
        Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Not all checkboxes were selected.");


    }
}
