package com.herokuapp.theinternet.pages;

import lombok.Getter;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Getter
public class EditorPage extends BasePageObject{

    private By frame = By.tagName("iframe");
    private By bodyLocator = By.id("tinymce");
    //private By frame = By.xpath("//*[@id=\"mce_0_ifr\"]");

    public EditorPage(WebDriver driver, Logger log){
        super(driver, log);
    }

    /** Get text from TinyMCE WYSIWYG Editor */
    public String getEditorText() {
        switchToFrame(frame);
        String text = find(bodyLocator).getText();
        log.info("Text from TinyMCE WYSIWYG Editor: " + text);
        return text;
    }





}
