package com.herokuapp.theinternet.alertsTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.AlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Alert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AlertTests extends TestUtilities {

    @Test
    public void clickJSAlertTest(){
        log.info("Starting test: clickJSAlertTest ");

        //Open Welcome page
        WelcomePage welcomePage= new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open JavaScripts alerts by clicking on the link
        AlertsPage alertsPage = welcomePage.openAlertPage();


        //Click on JS Alert button
        alertsPage.clickJSAlertButton();
        Alert jsAlert = alertsPage.swicthToAlert();

        //Accept JS Alert
        jsAlert.accept();

        //Verifications
        log.info("Starting verifications");
        SoftAssert soft = new SoftAssert();

        //Check the jvascripts_alerts URL
        String currentURL = alertsPage.getCurrentUrl();
        soft.assertEquals(alertsPage.getCurrentUrl(),alertsPage.getAlertsPageURL(), "Incorrect URL found: ");

        //Verify the test result: "You successfully clicked an alert"
        String alertMessage = alertsPage.getResultMessage();
        soft.assertEquals(alertMessage,"You successfuly clicked an alert", "Incorrect result message: " );

        soft.assertAll();

        log.info("Test completed!");
    }

    @Test(enabled = false)
    public void clickJSConfirmTest(){
        //Open Welcome page

        //Open JavaScripts alerts by clicking on the link

        //Click on Click for JS Confirm button

        //Confirm alert

        //Verify the test result: "You clicked: Ok"

    }

    @Test(enabled = false)
    public void cancelJSConfirmTest(){
        //Open Welcome page

        //Open JavaScripts alerts by clicking on the link

        //Click on on Click for JS Confirm button

        //Cancel Alert

        //Verify the test result: "You clicked: Cancel"

    }

    @Test(enabled = false)
    public void confirmJSPrompt(String message){
        //Open Welcome page

        //Open JavaScripts alerts by clicking on the link

        //Click on Click for JS Prompt

        //Enter message in input box

        //Verify the test result: "You entered: " + message
    }

    @Test(enabled = false)
    public void cancelJSPrompt(String message){
        //Open Welcome page

        //Open JavaScripts alerts by clicking on the link

        //Click on Click for JS Prompt

        //Enter message in input box

        //Cancel JS prompt

        //Verify the test result: "You entered: null"
    }
}
