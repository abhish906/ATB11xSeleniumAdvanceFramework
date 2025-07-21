package com.thetestingacademy.pages.pageObjectModel.Improved_POM.VWO;

import com.thetestingacademy.base.CommonToAllPage;
import com.thetestingacademy.util.waitHelpers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends CommonToAllPage {

    WebDriver wd;
    public DashboardPage(WebDriver wd)
    {
        this.wd=wd;
    }

    // Page Locators

    By  userNameOnDashboard= By.cssSelector("[data-qa='lufexuloga']");

    // Page actions
    public String LoggedinUsername()
    {
        waitHelpers.visibilityOfElement(userNameOnDashboard);
        return gettext(userNameOnDashboard);
    }





}
