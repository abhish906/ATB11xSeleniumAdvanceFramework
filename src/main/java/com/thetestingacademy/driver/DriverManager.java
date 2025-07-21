package com.thetestingacademy.driver;

import com.thetestingacademy.util.PropertiesReaders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {

    public static WebDriver wd;
// We have used getter and setter method to use the driver in waitsclass
    public static WebDriver getDriver() {
        return wd;
    }

    public static void setDriver(WebDriver wd) {
        DriverManager.wd = wd;
    }

// When we want to start the browser
    public static void init() {
        String browser = PropertiesReaders.readkey("browser");
        browser=browser.toLowerCase();

        switch (browser) {
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                edgeOptions.addArguments("--start-maximized");
                edgeOptions.addArguments("--guest");
                wd = new EdgeDriver(edgeOptions);
                break;
            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--start-maximized");
                wd = new ChromeDriver(chromeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("--start-maximized");
                wd = new FirefoxDriver(firefoxOptions);
                break;
            default:
                System.out.println("Browser Not Supported!!!");
        }
    }

       public static void down(){
           if(getDriver()!=null)
           {
               wd.quit();
               wd=null;
           }

        }



    }




