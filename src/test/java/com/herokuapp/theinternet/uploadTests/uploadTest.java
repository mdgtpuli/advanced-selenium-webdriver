package com.herokuapp.theinternet.uploadTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.UploadFilePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class uploadTest extends TestUtilities {

    @Test
    public void uploadFileTest(){
        log.info("Starting test: uploadFileTest");
        String filePath= "src/main/resources/images/happy.png";
        String fileName = "happi.png";
        String expectedTest = "File Uploaded";

        //Open File Upload page: http://the-internet.herokuapp.com/upload
        UploadFilePage uploadFilePage = new UploadFilePage(driver, log);
        uploadFilePage.openPage();

        //Select File from Path src/main/resources/images/happy.png
        uploadFilePage.selectFile(filePath);

        //Click Upload button
        uploadFilePage.clickUploadButton();

        //Verifications
        log.info("Starting verifications");

        SoftAssert soft = new SoftAssert();

        //Verify the text: "File Uploaded!"
        soft.assertTrue(uploadFilePage.getCurrentPageSource().contains(expectedTest),
                "Expected text not found in the page. Missing: " + expectedTest);


        //Verify the file name
        soft.assertEquals(fileName, uploadFilePage.getUploadedFileName(),
                "File name does not match the expected one");

        soft.assertAll();

        log.info("Test completed!");
    }
}
