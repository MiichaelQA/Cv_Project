package com.Etsy;

import com.Etsy.pages.HomePageHelper;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import gurock.testrail.APIClient;
import gurock.testrail.APIException;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import org.json.simple.JSONObject;


public class TestBase {

    public ChromeDriver driver = new ChromeDriver();
    protected static String baseUrl = "https://www.etsy.com/";
    public Actions builder = new Actions(driver);
    HomePageHelper homePage;


    public static String TestRailRunId    = "2" ;
    public static String TestRailUsername = "qaautomationcvproject@gmail.com";
    public static String TestRailPassword = "ue8h5hnORDN.wcGj9Rhh";
    public static final int TEST_CASE_PASSED_STATUS = 1;
    public static final int TEST_CASE_FAILED_STATUS = 5;
    public static APIClient client = new APIClient("https://qaautomationcvprojectgmail.testrail.io/");


    public static void AddResultForTestCaseInTestRail(String TestCaseId, int status)
            throws IOException, APIException {
        client.setUser(TestRailUsername);
        client.setPassword(TestRailPassword);

        Map data = new HashMap();
        data.put("status_id", status);
        data.put("comment", "This test worked fine!");
        JSONObject r = (JSONObject) client.sendPost("add_result_for_case/" +TestRailRunId+ "/"+TestCaseId+"", data);
    }


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
