package com.thetestingacademy.util;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import java.util.function.Function;

import static com.thetestingacademy.driver.DriverManager.getDriver;
import static java.sql.DriverManager.getDriver;

public class waitHelpers {
    public static void waitJVM(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waitImplicitWait(WebDriver wd,int time){
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
    }


    public static void checkVisibility(WebDriver wd, By locator,int time){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibility(WebDriver wd, By locator){
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void checkVisibilityOfAndTextToBePresentInElement(WebDriver driver, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.textToBePresentInElement(element, "Your email, password, IP address or location did not match"));

    }

    public static WebElement checkVisibilityByFluentWait(WebDriver wd, By locator) {
        FluentWait<WebDriver> wait = new FluentWait<>(wd)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

        WebElement error_message = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(locator);
            }
        });
        return error_message;
    }

    public static WebElement presenceOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement presenceOfElement(WebDriver wd, By elementLocation) {
        return new WebDriverWait(wd, Duration.ofSeconds(20)).until(ExpectedConditions.presenceOfElementLocated(elementLocation));
    }

    public static WebElement visibilityOfElement(By elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
    }

    public static WebElement visibilityOfElement(WebElement elementLocation) {
        return new WebDriverWait(getDriver(), Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(elementLocation));
    }

    public WebElement getElement(By key) {
        return getDriver().findElement(key);
    }



}
