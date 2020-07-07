package com.Esty;

import com.Esty.pages.HomePageHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


public class TestBase {

    public ChromeDriver driver = new ChromeDriver();
    protected static String baseUrl = "https://www.etsy.com/";
    public Actions builder = new Actions(driver);
    public static final String LOGIN = "";
    public static final String PASSWORD = "";
    HomePageHelper homePage;

    @BeforeSuite
    public void initWebDriver(){
        homePage = PageFactory.initElements(driver,HomePageHelper.class);
        driver.get(baseUrl);
        driver.manage().window().fullscreen();
        homePage.waitUntilPageIsLoaded();
    }
    @AfterMethod
    public void RdyForNewTest(){
        driver.get(baseUrl);
        homePage.waitUntilPageIsLoaded();
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
