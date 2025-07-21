package com.thetestingacademy.base;

import com.thetestingacademy.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class CommontoAll {

    @BeforeMethod
    public void setup(){
        DriverManager.init();

    }




    @AfterMethod
    public  void teardown()
    {
        DriverManager.down();
    }

}
