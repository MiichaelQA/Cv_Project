package com.Esty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageHelper extends PageBase {
    String name;
    @FindBy(xpath = "//span[@id='logo']//*[local-name()='svg']")
    WebElement logo;

    @FindBy(xpath = "//h2[@class='wt-text-heading-02 mb-xs-2']")
    WebElement WhatIsEtsy;

    @FindBy(xpath = "//button[contains(text(),'Subscribe')]")
    public WebElement SubscribeButton;

    @FindBy(xpath = "//input[@id='email-list-signup-email-input']")
    public WebElement SubscribeField;

    @FindBy(xpath = "//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']")
    public WebElement UnicSubMail;

    @FindBy(xpath = "//div[@class='wt-alert wt-alert--inline wt-alert--status-01 wt-text-body-01']")
    public WebElement UsedSubMail;

    public String TitleVerification(){
        return WhatIsEtsy.getText();
    }

    public HomePageHelper (WebDriver driver){
        super(driver);
    }

    public void waitUntilPageIsLoaded()  {
        waitUntilElementIsClickable(logo, 40);
    }

    @Override
    public void waitUntilElementIsVisible() {

    }

    public void waitUntilFieldSubsIsClicable(){
        waitUntilElementIsClickable(SubscribeField, 40);
    }

    public boolean verifyIfSubsMailUnic(){
        return driver.findElement(By.
                xpath("//div[@class='wt-alert wt-alert--inline wt-alert--success-01 wt-text-body-01']")
        ).getText().contains("Great! We've sent you an email to confirm your subscription.");
    }

    public boolean verifyIfSubsMailUsed(){
        return driver.findElement(By.
                xpath("//div[@class='wt-alert wt-alert--inline wt-alert--status-01 wt-text-body-01']")
        ).getText().contains("Looks like you already have an account! Please Log in to subscribe.");
    }
}
