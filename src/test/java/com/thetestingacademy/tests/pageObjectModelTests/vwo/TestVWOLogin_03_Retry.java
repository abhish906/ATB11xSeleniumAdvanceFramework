package com.thetestingacademy.tests.pageObjectModelTests.vwo;

import com.thetestingacademy.base.CommontoAll;
import com.thetestingacademy.listeners.RetryAnalyzer;
import com.thetestingacademy.listeners.ScreenShotListener;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;

@Listeners(ScreenShotListener.class)

@Test(retryAnalyzer = RetryAnalyzer.class)

public class TestVWOLogin_03_Retry extends CommontoAll {

    private static final Logger logger=LogManager.getLogger(TestVWOLogin_03_Retry.class);

    @Owner("Abhishek")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testFail() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
       Allure.addAttachment("Log output","text/plain","This is some log text");
        Assert.assertTrue(false);
    }

    @Owner("Abhishek")
    @Description("Verify that invalid creds give error message")
    @Test
    public void testPass() {
        getDriver().get("https://app.vwo.com");
        logger.info("Starting the Testcases Page Object Model");
        Assert.assertTrue(true);
    }




}
