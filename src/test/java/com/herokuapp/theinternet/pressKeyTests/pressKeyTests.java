package com.herokuapp.theinternet.pressKeyTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class pressKeyTests extends TestUtilities {

    @Test
    public void pressEnterKeyTest(){
        String expectedMessage= "You entered: ENTER";
        log.info("Starting test: pressEnterKeyTest");

        //Open Key presses page: http://the-internet.herokuapp.com/key_presses
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openKeyPressesPage();


        //Press Enter key with locator and Key
        keyPressesPage.pressKey(Keys.ENTER);


        //Verify the text message: "You entered: ENTER"
        log.info("Starting verifications!");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedMessage, keyPressesPage.getResultMessage());

        soft.assertAll();

        log.info("test completed!");
    }

    @Test
    public void pressEnterKeyWithActionsTest(){
        String expectedMessage= "You entered: ENTER";

        log.info("Starting test: pressEnterKeyWithActionsTest");

        //Open Key presses page: http://the-internet.herokuapp.com/key_presses
        KeyPressesPage keyPressesPage = new KeyPressesPage(driver, log);
        keyPressesPage.openKeyPressesPage();


        //Press Enter key with locator and Key using the Actions method
        keyPressesPage.pressKeyWithAction(Keys.ENTER);


        //Verify the text message: "You entered: ENTER"
        log.info("Starting verifications!");

        SoftAssert soft = new SoftAssert();
        soft.assertEquals(expectedMessage, keyPressesPage.getResultMessage());

        soft.assertAll();

        log.info("test completed!");

    }
}
