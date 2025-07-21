package com.thetestingacademy.pages.pageObjectModel.normal_POM.VWO;

import com.thetestingacademy.util.PropertiesReaders;
import com.thetestingacademy.util.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    static WebDriver wd;

    //We are using constructor here to make sure that whenever the login page is used, driver is available
    public LoginPage(WebDriver wd) {
        LoginPage.wd = wd;
    }


    // Step 1- Page Locators
    private By username = By.id("login-username");
    private By password = By.id("login-password");
    private By signButton = By.id("js-login-btn");
    private By error_message = By.id("js-notification-box-msg");

    // If you are not using it , don't keep.
    //private By signBySSO = By.xpath("//button[normalize-space()='Sign in using SSO']");

    //Page Actions

    public String loginToVWOLoginInvalidCreds(String user, String pwd) {
        wd.get(PropertiesReaders.readkey("url"));
        wd.findElement(username).sendKeys(user);
        wd.findElement(password).sendKeys(pwd);

        wd.findElement(signButton).click();


        //Wait for JVM-Thread Sleep

        // waitHelpers.waitJVM(5000);


        //Alternate option
        waitHelpers.checkVisibility(wd, error_message);

        String error_message_text = wd.findElement(error_message).getText();

        return error_message_text;



}
    public void loginToVWOLoginValidCreds(String user,String pwd) {
        wd.get(PropertiesReaders.readkey("url"));
        wd.findElement(username).sendKeys(user);
        wd.findElement(password).sendKeys(pwd);

        wd.findElement(signButton).click();

        //Wait for JVM-Thread Sleep

        waitHelpers.waitJVM(5000);



    }


}
