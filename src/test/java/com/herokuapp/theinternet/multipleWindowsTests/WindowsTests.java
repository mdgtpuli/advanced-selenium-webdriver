package com.herokuapp.theinternet.multipleWindowsTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.NewWindowsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.WindowsPage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WindowsTests extends TestUtilities {

    @Test(enabled = true)
    public void openNewWindowTest(){
        log.info("Starting test: openNewWindowTest");
        String expectedText = "New Window";

        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open Multiple Windows page by clicking on the link
        WindowsPage windowsPage = welcomePage.openMultipleWindowsPage();

        //Click on "click here"
        windowsPage.clickHereButton();
        NewWindowsPage newWindowsPage = windowsPage.switchToNewWindowsPage();


        //Verify the content of the new page contains text "new window"
        log.info("Starting assertions");
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(newWindowsPage.getCurrentPageSource().contains(expectedText));
        soft.assertAll();

        log.info("Test completed!");
    }
}
