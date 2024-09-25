package org.evy.test;

import org.evy.toolkit.drivers.Driver;
import org.evy.toolkit.utils.LoggerUtils;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{

    @Test
    public void testUserLogin(){
       LoggerUtils.info(getClass(),Driver.getInstance().getDriver().getTitle());
    }
}
