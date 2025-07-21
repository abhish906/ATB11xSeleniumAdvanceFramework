package com.thetestingacademy.tests.sample;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCaseBoilerPlate {
    public EdgeDriver wd;

    @BeforeTest
    public void openBrowser() {

        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--guest");
        wd = new EdgeDriver(edgeOptions);
        wd.manage().window().maximize();

    }

    @Test
    public void test() {
        wd.get("https://app.vwo.com");
        Assert.assertEquals(wd.getTitle(), "Login - VWO");
    }

    @AfterTest
    public void closeBrowser() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        wd.quit();
    }
}
