package com.thetestingacademy.pages.pageFactory.vwo;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.util.PropertiesReaders;
import com.thetestingacademy.util.waitHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.SQLOutput;

public class LoginPage_PF extends CommonToAllPage {


    WebDriver wd;
    public LoginPage_PF(WebDriver wd)
    {
        this.wd=wd;
        //Initializing the webelements using initElements() method
        PageFactory.initElements(wd,this);
    }

    @FindBy(id = "login-username")
    private WebElement username;

    @FindBy(id="login-password")
    private WebElement password;

    @FindBy(id = "js-login-btn")
    private WebElement signButton;

    @FindBy(id="js-notification-box-msg")
    private WebElement error_message;

    // Page actions

    public String loginToVWOLoginInvalidCreds()
    {
        try {
            openVWOUrl();
            enterinput(username, PropertiesReaders.readkey("invalid_username"));
            enterinput(password, PropertiesReaders.readkey("invalid_password"));
            clickElement(signButton);
            waitHelpers.waitJVM(5000);
        } catch (Exception e) {
            System.out.println("Element not found");
        }
        return gettext(error_message);

    }

    public void  loginToVWOLoginValidCreds()
    {
        openVWOUrl();
        enterinput(username, PropertiesReaders.readkey("username"));
        enterinput(password,PropertiesReaders.readkey("password"));
        clickElement(signButton);
        waitHelpers.waitJVM(5000);


    }








}
