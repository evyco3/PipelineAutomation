package org.evy.toolkit.configs;

import org.aeonbits.owner.Config;
import org.evy.toolkit.drivers.DriverType;

/**
 * Configuration interface for the toolkit, mapping properties from the config file.
 */
@Config.Sources("file:${user.dir}/src/main/resources/config.properties")
public interface ToolkitConfig extends Config {

    /**
     * Retrieves the driver type for the WebDriver.
     *
     * @return the DriverType enum.
     */
    @ConverterClass(DriverTypeConverter.class)
    @DefaultValue("CHROME")
    @Key("driverType")
    DriverType driverType();

    /**
     * Retrieves the page load timeout in seconds.
     *
     * @return the page load timeout.
     */
    @Key("pageLoadTime")
    int pageLoadTime();

    /**
     * Retrieves the implicit wait time in seconds.
     *
     * @return the implicit wait time.
     */
    @Key("implicitTime")
    int implicitTime();

    /**
     * Retrieves the base URL for the application.
     *
     * @return the base URL.
     */
    @Key("baseUrl")
    String baseUrl();

    /**
     * Retrieves the email for authentication or other purposes.
     *
     * @return the email address.
     */
    @Key("email")
    String email();

    /**
     * Retrieves the password for authentication.
     *
     * @return the password.
     */
    @Key("password")
    String password();
}
