package com.thetestingacademy.tests.pageObjectModelTests.vwo;

import com.thetestingacademy.base.CommontoAll;
import com.thetestingacademy.driver.DriverManager;
import com.thetestingacademy.pages.pageObjectModel.normal_POM.VWO.DashboardPage;
import com.thetestingacademy.pages.pageObjectModel.normal_POM.VWO.LoginPage;
import com.thetestingacademy.util.PropertiesReaders;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.getDriver;
import static com.thetestingacademy.driver.DriverManager.wd;
import static org.assertj.core.api.Assertions.*;

public class TestVWOLogin_01_NormalScript_POM extends CommontoAll {

    @Owner("Abhishek")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){
        // Driver Manager Code - 1

        WebDriver wd= DriverManager.getDriver();


        // Page Class Code (POM Code) - 2
        LoginPage loginPage=new LoginPage(wd);
        String error_msg= loginPage.loginToVWOLoginInvalidCreds(PropertiesReaders.readkey("invalid_username"),PropertiesReaders.readkey("invalid_password"));


        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReaders.readkey("error_message"));


    }

    @Owner("Abhishek")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        LoginPage loginPage=new LoginPage(wd);
        loginPage.loginToVWOLoginValidCreds(PropertiesReaders.readkey("username"),PropertiesReaders.readkey("password"));

       /* DashboardPage dashboardPage=new DashboardPage(wd);
       String usernameloggedIn=  dashboardPage.loggedInUserName();

       assertThat(usernameloggedIn).isNotEmpty().isNotBlank().isNotNull();

       Assert.assertEquals(usernameloggedIn,PropertiesReaders.readkey("expected_username"))*/;




    }
}
