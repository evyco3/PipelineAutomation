package com.evy.test;

import org.evy.toolkit.drivers.Driver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testUserLogin(){
        System.out.println(Driver.getInstance().getDriver().getTitle());
    }
}
