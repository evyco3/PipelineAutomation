package com.evy.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BaseTest {

    @Test
    public void test(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver=new ChromeDriver(options);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
