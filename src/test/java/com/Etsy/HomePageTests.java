package com.Etsy;

import com.Etsy.pages.ContextBarHelper;
import com.Etsy.pages.HomePageHelper;
import gurock.testrail.APIException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends TestBase {

    HomePageHelper homePage;
    ContextBarHelper contextBar;

    @BeforeMethod
    public void initTests() {
        homePage = PageFactory.initElements(driver, HomePageHelper.class);
        contextBar = PageFactory.initElements(driver, ContextBarHelper.class);
    }

    @Test
    public void VerifiHomePage() {
            Assert.assertEquals(homePage.TitleVerification(), "What is Etsy?");
    }

    @Test
    public void SubscribeFieldUnicPositive() throws APIException, IOException {
        homePage.waitUntilFieldSubsIsClicable();
        homePage.SubscribeField.sendKeys("miklomac@gmail.com");
        homePage.SubscribeButton.click();
        homePage.waitUntilElementIsVisible(homePage.UnicSubMail, 10);

        if(homePage.verifyIfSubsMailUnic()){
            TestBase.AddResultForTestCaseInTestRail("5", TEST_CASE_PASSED_STATUS);
        } else {
            TestBase.AddResultForTestCaseInTestRail("5", TEST_CASE_FAILED_STATUS);
        }
        Assert.assertTrue(homePage.verifyIfSubsMailUnic());
    }

    @Test()
    public void SubscribeFieldUsedPositive() throws APIException, IOException {
        homePage.waitUntilFieldSubsIsClicable();
        homePage.SubscribeField.sendKeys("logo@gmail.com");
        homePage.SubscribeButton.click();
        homePage.waitUntilElementIsVisible(homePage.UsedSubMail, 10);

        if (homePage.verifyIfSubsMailUsed()){
            TestBase.AddResultForTestCaseInTestRail("4", TEST_CASE_PASSED_STATUS);
        } else {
            TestBase.AddResultForTestCaseInTestRail("4", TEST_CASE_FAILED_STATUS);
        }
        Assert.assertTrue(homePage.verifyIfSubsMailUsed());

    }

    @Test
    public void TestContextMenu() throws APIException, IOException {
        builder.moveToElement(contextBar.CtgWeddingParty).perform();
        contextBar.waitUntilElementIsVisible(contextBar.SubCtgWeddingDecor,10);
        builder.moveToElement(contextBar.SubCtgWeddingDecor).perform();
        contextBar.waitUntilElementIsVisible(contextBar.SubCtgButtonCakeToppers,10);
        contextBar.SubCtgButtonCakeToppers.click();

        if(contextBar.verifyContextFinish()) {
            TestBase.AddResultForTestCaseInTestRail("6", TEST_CASE_PASSED_STATUS);
        }else{
            TestBase.AddResultForTestCaseInTestRail("6", TEST_CASE_FAILED_STATUS);
        }
        Assert.assertTrue(contextBar.verifyContextFinish());
    }

}
