package com.Esty.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContextBarHelper extends PageBase {

    /*I can describe 8 categories and all subcategories
    but it's is not relevant for CV project.*/

    @FindBy(xpath = "//span[@id='catnav-primary-link-10983']")
    public WebElement CtgWeddingParty;

    //SubCategories
    @FindBy(xpath = "//span[@id='side-nav-category-link-10996']")
    public WebElement SubCtgWeddingDecor;

    @FindBy(xpath = "//a[@id='catnav-l3-10998']")
    public WebElement SubCtgButtonCakeToppers;


    public ContextBarHelper(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {
    }

    @Override
    public void waitUntilElementIsVisible() {
    }

    public boolean verifyContextFinish(){
        return driver.findElement(By.
                xpath("//a[@class='wt-text-gray wt-text-link'][contains(text(),'Cake Toppers')]")).
                getText().contains("Cake Toppers");
    }
}
