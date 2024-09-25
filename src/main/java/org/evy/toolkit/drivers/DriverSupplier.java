package org.evy.toolkit.drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.evy.toolkit.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public final class DriverSupplier {

    private DriverSupplier() {}

    /**
     * Returns a WebDriver instance based on the specified DriverType.
     *
     * @param driverType the type of driver to initialize
     * @return a WebDriver instance
     */
    public static WebDriver getDriver(DriverType driverType) {
        WebDriver driver;
        try {
            driver = switch (driverType) {
                case CHROME -> {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    LoggerUtils.info(DriverSupplier.class, "Initializing Chrome Driver");
                    yield new ChromeDriver(options);
                }
                case FIREFOX -> {
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--headless");
                    LoggerUtils.info(DriverSupplier.class, "Initializing Firefox Driver");
                    yield new FirefoxDriver(options);
                }
                case EDGE -> {
                    WebDriverManager.edgedriver().setup();
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--headless");
                    LoggerUtils.info(DriverSupplier.class, "Initializing Edge Driver");
                    yield new EdgeDriver(options);
                }
                case EXPLORER -> {
                    WebDriverManager.iedriver().setup();
                    LoggerUtils.info(DriverSupplier.class, "Initializing Internet Explorer Driver");
                    yield new InternetExplorerDriver();
                }
                case SAFARI -> {
                    WebDriverManager.safaridriver().setup();
                    LoggerUtils.info(DriverSupplier.class, "Initializing Safari Driver");
                    yield new SafariDriver();
                }
                case OPERA -> {
                    WebDriverManager.operadriver().setup();
                    LoggerUtils.info(DriverSupplier.class, "Initializing Opera Driver");
                    yield new ChromeDriver();
                }
            };
        } catch (Exception e) {
            LoggerUtils.error(DriverSupplier.class, "Failed to initialize WebDriver", e);
            throw e;
        }

        LoggerUtils.info(DriverSupplier.class, "WebDriver initialized successfully");
        return driver;
    }
}
