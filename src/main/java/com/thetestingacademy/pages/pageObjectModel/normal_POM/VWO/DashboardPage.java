package com.thetestingacademy.pages.pageObjectModel.normal_POM.VWO;

import com.thetestingacademy.util.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {

    static WebDriver wd;
    public DashboardPage(WebDriver wd){
        this.wd=wd;
    }

    //Page Locators
    private By userNameOnDashboard=By.cssSelector("[data-qa='lufexuloga']");


    //Page Actions

    public String loggedInUserName(){
        waitHelpers.waitJVM(5000);
        wd.get("https://app.vwo.com/#/dashboard");
        String verify_uname=wd.findElement(userNameOnDashboard).getText();
        return  verify_uname;


    }



}
