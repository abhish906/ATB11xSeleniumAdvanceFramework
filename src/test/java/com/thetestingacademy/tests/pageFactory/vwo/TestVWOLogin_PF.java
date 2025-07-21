package com.thetestingacademy.tests.pageFactory.vwo;

import com.thetestingacademy.base.CommontoAll;
import com.thetestingacademy.pages.pageFactory.vwo.DashBoard_PF;
import com.thetestingacademy.pages.pageFactory.vwo.LoginPage_PF;
import com.thetestingacademy.util.PropertiesReaders;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.apache.logging.log4j.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.thetestingacademy.driver.DriverManager.wd;
import static org.assertj.core.api.Assertions.assertThat;

public class TestVWOLogin_PF extends CommontoAll {

    private static final Logger logger=LogManager.getLogger(TestVWOLogin_PF.class);


    @Owner("Abhishek")
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){
        // Driver Manager Code - 1
         logger.info("Starting the TestCases Page Factory");

        // Page Class Code (POM Code) - 2
        LoginPage_PF loginPage=new LoginPage_PF(wd);
        String error_msg= loginPage.loginToVWOLoginInvalidCreds();
        logger.info("Error msg I got "+ error_msg);
        logger.info("Finished the TestCases Page Factory");
        logger.debug("Finished the TestCases Page Factory");
        logger.error("Finished the TestCases Page Factory");
        logger.fatal("Fatal error - code is dead!");


        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReaders.readkey("error_message"));







    }


    @Owner("Abhishek")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void test_positive_vwo_login() {
        logger.info("Starting the TestCases Page Factory");

        LoginPage_PF loginPage = new LoginPage_PF(wd);
        loginPage.loginToVWOLoginValidCreds();

        DashBoard_PF dashboardPage = new DashBoard_PF(wd);
        String usernameloggedIn = dashboardPage.loggedinUsername();
        logger.info("usernameloggedIn  I got "+ usernameloggedIn);
        logger.info("Finished the TestCases Page Factory");
        logger.debug("Finished the TestCases Page Factory");
        logger.error("Finished the TestCases Page Factory");
        logger.fatal("Fatal error - code is dead!");

        assertThat(usernameloggedIn).isNotEmpty().isNotBlank().isNotNull();

        Assert.assertEquals(usernameloggedIn, PropertiesReaders.readkey("expected_username"));
    }



    }
