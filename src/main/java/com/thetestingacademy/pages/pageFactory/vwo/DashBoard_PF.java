package com.thetestingacademy.pages.pageFactory.vwo;

import com.thetestingacademy.base.CommonToAllPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.thetestingacademy.util.waitHelpers.visibilityOfElement;

public class DashBoard_PF extends CommonToAllPage {

    WebDriver wd;
    public DashBoard_PF(WebDriver wd)
    {
        this.wd=wd;
        PageFactory.initElements(wd,this);
    }

    //Page locators
    @FindBy(css="[data-qa='lufexuloga']")
    private WebElement userNameOnDashboard;

    //PageActions
    public String loggedinUsername()
    {
        visibilityOfElement(userNameOnDashboard);
        return gettext(userNameOnDashboard);
    }


}
