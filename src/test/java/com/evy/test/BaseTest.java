package com.evy.test;

import org.evy.toolkit.drivers.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    @BeforeMethod
    public void setup(){
        Driver.getInstance().initDriver();
    }

    @AfterMethod
    public void tearDown(){
        Driver.getInstance().quitDriver();
    }
}
