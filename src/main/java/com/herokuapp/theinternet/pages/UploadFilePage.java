package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UploadFilePage extends BasePageObject{

    private String URL = "http://the-internet.herokuapp.com/upload";
    private By selectFileLocator = By.id("file-upload");
    private By uploadButtonLocator = By.id("file-submit");
    private By uploadedFileLocator = By.id("uploaded-files");

    public UploadFilePage(WebDriver driver, Logger log){
        super(driver, log);
    }

    //Open File Upload page
    public void openPage(){
        log.info("Opening File Upload page");
        driver.get(URL);
        log.info("Page opened!");
    }

    //Send file path to selectFile for upload
    public void selectFile(String path){
        log.info("Selecting file from path: "+ path);
        String filePath = System.getProperty("user.dir") + path;
        type(selectFileLocator, filePath);
    }

    //Click on Upload button
    public void clickUploadButton(){
        click(uploadButtonLocator);
        log.info("Upload button clicked!");
    }

    //Get


    //Get uploaded file name
    public String getUploadedFileName(){
       String uploadedFileName = find(uploadedFileLocator).getText();
        log.info("Uploaded file name is: " + uploadedFileName);
        return uploadedFileName;
    }
}
