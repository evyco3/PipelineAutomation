package org.evy.toolkit.drivers;

import org.evy.toolkit.configs.Config;
import org.evy.toolkit.utils.LoggerUtils;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public final class Driver {

    private static final ThreadLocal<WebDriver> DRIVER_THREAD_LOCAL = new ThreadLocal<>();
    private static final Driver INSTANCE = new Driver();

    private Driver() {}

    public static Driver getInstance() {
        return INSTANCE;
    }

    /**
     * Initializes the WebDriver instance and configures it.
     */
    public void initDriver() {
        try {
            WebDriver driver = DriverSupplier.getDriver(Config.getConfig().driverType());
            configure(driver);
            DRIVER_THREAD_LOCAL.set(driver);
            LoggerUtils.info(Driver.class, "WebDriver set to ThreadLocal.");
        } catch (Exception e) {
            LoggerUtils.error(Driver.class, "Failed to initialize WebDriver", e);
            throw e;
        }
    }

    /**
     * Quits the WebDriver instance and removes it from ThreadLocal.
     */
    public void quitDriver() {
        try {
            WebDriver driver = DRIVER_THREAD_LOCAL.get();
            if (driver != null) {
                driver.quit();
                LoggerUtils.info(Driver.class, "WebDriver quit successfully ");

                DRIVER_THREAD_LOCAL.remove();
                LoggerUtils.info(Driver.class, "WebDriver removed from ThreadLocal.");
            } else {
                LoggerUtils.warn(Driver.class, "No WebDriver instance found to quit.");
            }
        } catch (Exception e) {
            LoggerUtils.error(Driver.class, "Failed to quit WebDriver", e);
        }
    }

    /**
     * Retrieves the current WebDriver instance from ThreadLocal.
     *
     * @return WebDriver instance or null if not set
     */
    public WebDriver getDriver() {
        WebDriver driver = DRIVER_THREAD_LOCAL.get();
        if (driver == null) {
            LoggerUtils.warn(Driver.class, "No WebDriver instance available in ThreadLocal.");
        }
        return driver;
    }

    /**
     * Configures the given WebDriver instance with timeouts and an initial URL.
     *
     * @param driver the WebDriver instance to configure
     */
    private void configure(WebDriver driver) {
        try {
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Config.getConfig().pageLoadTime()));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Config.getConfig().implicitTime()));
            driver.get(Config.getConfig().baseUrl());
            LoggerUtils.info(Driver.class, "WebDriver configured successfully.");
        } catch (Exception e) {
            LoggerUtils.error(Driver.class, "Failed to configure WebDriver", e);
            throw e;
        }
    }
}
