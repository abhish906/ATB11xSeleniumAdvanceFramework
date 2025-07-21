package com.thetestingacademy.pages.pageObjectModel.Improved_POM.VWO;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.util.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static com.thetestingacademy.driver.DriverManager.*;

public class LoginPage extends CommonToAllPage {

    WebDriver wd;

    public LoginPage(WebDriver wd) {
        this.wd = wd;
    }

    // Step 1- Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    //Page Actions
    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        openVWOUrl();
        enterinput(username, user);
        enterinput(password, pwd);
        clickElement(signButton);
//          String error_msg = gettext(error_message);
//             return error_msg;
        waitHelpers.checkVisibility(getDriver(),error_message);

        return gettext(error_message);
    }


    public void loginToVWOLoginValidCreds(String user,String pwd)
    {
        openVWOUrl();
        enterinput(username,user);
        enterinput(password,pwd);
        clickElement(signButton);
        waitHelpers.waitJVM(5000);



    }






}
