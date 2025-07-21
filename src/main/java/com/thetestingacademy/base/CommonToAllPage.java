package com.thetestingacademy.base;

import com.thetestingacademy.util.PropertiesReaders;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.thetestingacademy.driver.DriverManager.getDriver;

public class CommonToAllPage {


    public CommonToAllPage()
    {}


    public  void openVWOUrl(){
        getDriver().get(PropertiesReaders.readkey("url"));
    }

    public void openOrangeHRMUrl(){
        getDriver().get(PropertiesReaders.readkey("ohr_url"));

    }

    public void openKatalonUrl(){
        getDriver().get(PropertiesReaders.readkey("katalon_url"));

    }

    public void clickElement(By by)
    {
        getDriver().findElement(by).click();
    }

    public void clickElement(WebElement by)
    {
        by.click();
    }
    public void enterinput(By by,String key)
    {
       getDriver().findElement(by).sendKeys(key);
    }
    public void enterinput(WebElement by,String key)
    {
        by.sendKeys(key);
    }

    public String gettext(By by)
    {
        return getDriver().findElement(by).getText();
    }

    public String gettext(WebElement by)
    {
        return by.getText();
    }



}
