package com.Etsy;

import com.Etsy.pages.ContextBarHelper;
import com.Etsy.pages.HomePageHelper;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    HomePageHelper homePage;
    ContextBarHelper contextBar;

    @BeforeMethod
    public void initTests(){
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        contextBar = PageFactory.initElements(driver,ContextBarHelper.class);
    }

    @Test
    public void VerifiHomePage(){
        Assert.assertEquals(homePage.TitleVerification(),"What is Etsy?");
    }

    @Test
    public void SubscribeFieldUnicPositive(){
        homePage.waitUntilFieldSubsIsClicable();
        homePage.SubscribeField.sendKeys("miklomac@gmail.com");
        homePage.SubscribeButton.click();
        homePage.waitUntilElementIsVisible(homePage.UnicSubMail, 10);
        Assert.assertTrue(homePage.verifyIfSubsMailUnic());
    }

    @Test
    public void SubscribeFieldUsedPositive(){
        homePage.waitUntilFieldSubsIsClicable();
        homePage.SubscribeField.sendKeys("logo@gmail.com");
        homePage.SubscribeButton.click();
        homePage.waitUntilElementIsVisible(homePage.UsedSubMail, 10);
        Assert.assertTrue(homePage.verifyIfSubsMailUsed());
    }

    @Test
    public void TestContextMenu(){
        builder.moveToElement(contextBar.CtgWeddingParty).perform();
        contextBar.waitUntilElementIsVisible(contextBar.SubCtgWeddingDecor,10);
        builder.moveToElement(contextBar.SubCtgWeddingDecor).perform();
        contextBar.waitUntilElementIsVisible(contextBar.SubCtgButtonCakeToppers,10);
        contextBar.SubCtgButtonCakeToppers.click();
        Assert.assertTrue(contextBar.verifyContextFinish());
    }





}
