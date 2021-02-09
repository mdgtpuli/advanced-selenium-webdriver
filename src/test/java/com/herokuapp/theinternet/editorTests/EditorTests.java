package com.herokuapp.theinternet.editorTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.EditorPage;
import com.herokuapp.theinternet.pages.WelcomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class EditorTests extends TestUtilities {

    @Test
    public void checkEditorDefaultText(){
        log.info("Starting test: checkEditorDefaultText");

        String expectedText= "Your content goes here.";

        //Open welcome page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openWelcomePage();

        //Click on WYSIWYG edit button and open new page
        EditorPage editorPage = welcomePage.openEditorPage();
        String actualText = editorPage.getEditorText();


        //Switch to frame and check default content: "Your content goes here."
        SoftAssert soft = new SoftAssert();

        soft.assertEquals(actualText, expectedText, "Unexpected text in iFrame body.");
        soft.assertAll();

        log.info("Test completed!");

    }
}
