package com.herokuapp.theinternet.alertsTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.AlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class AlertTests extends TestUtilities {

    @Test(enabled = true)
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
        soft.assertEquals(alertsPage.getCurrentUrl(),alertsPage.getAlertsPageURL(), "Incorrect URL found: ");

        //Verify the test result: "You successfully clicked an alert"
        String alertMessage = alertsPage.getResultMessage();
        soft.assertEquals(alertMessage,"You successfuly clicked an alert", "Incorrect result message: " );

        soft.assertAll();

        log.info("Test completed!");
    }

    @Test(enabled = true)
    public void clickJSConfirmTest(){
        log.info("Starting test: clickJSConfirmTest");
        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open JavaScripts alerts by clicking on the link
        AlertsPage alertsPage = welcomePage.openAlertPage();

        //Click on Click for JS Confirm button
        alertsPage.clickJSConfirmButton();
        Alert jsConfirm = alertsPage.swicthToAlert();

        //Confirm alert
        jsConfirm.accept();


        //Verify the test result: "You clicked: Ok"
        Assert.assertEquals("You clicked: Ok", alertsPage.getResultMessage(), "Incorrect result message: ");

        log.info("Test completed!");

    }

    @Test(enabled = true)
    public void cancelJSConfirmTest(){
        log.info("Starting test: cancelJSConfirmTestc ");
        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open JavaScripts alerts by clicking on the link
        AlertsPage alertsPage= welcomePage.openAlertPage();

        //Click on on Click for JS Confirm button
        alertsPage.clickJSConfirmButton();
        Alert jsConfirm = alertsPage.swicthToAlert();

        //Cancel Alert
        jsConfirm.dismiss();

        //Verify the test result: "You clicked: Cancel"
        Assert.assertEquals("You clicked: Cancel", alertsPage.getResultMessage(), "Incorrect result message: ");

        log.info("Test completed!");

    }

    @Test(enabled = true)
    public void confirmJSPrompt(){
        String message = "Hello there!";

        log.info("Starting test: confirmJSPrompt ");
        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open JavaScripts alerts by clicking on the link
        AlertsPage alertsPage= welcomePage.openAlertPage();

        //Click on Click for JS Prompt
        alertsPage.clickJSPromptButton();
        Alert JSPrompt = alertsPage.swicthToAlert();

        //Enter message in input box
        JSPrompt.sendKeys(message);
        JSPrompt.accept();

        //Verify the test result: "You entered: " + message
        Assert.assertEquals(alertsPage.getResultMessage(), "You entered: "+ message,  "Incorrect input message: ");

        log.info("Test completed!");

    }
    @Test(enabled = true)
    public void cancelJSPrompt(){
        log.info("Starting test: cancelJSPrompt ");

        String message = "Cancel this!";

        //Open Welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Open JavaScripts alerts by clicking on the link
        AlertsPage alertsPage= welcomePage.openAlertPage();

        //Click on Click for JS Prompt
        alertsPage.clickJSPromptButton();
        Alert JSPrompt = alertsPage.swicthToAlert();

        //Enter message in input box
        JSPrompt.sendKeys(message);

        //Cancel JS prompt
        JSPrompt.dismiss();

        //Verify the test result: "You entered: null"
        Assert.assertEquals(alertsPage.getResultMessage(), "You entered: null",  "Incorrect input message: ");

        log.info("Test completed!");
    }
}
