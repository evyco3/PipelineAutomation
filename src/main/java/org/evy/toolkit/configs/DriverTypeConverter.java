package org.evy.toolkit.configs;

import org.aeonbits.owner.Converter;
import org.evy.toolkit.drivers.DriverType;

import java.lang.reflect.Method;

/**
 * Converter class to convert String values to DriverType enum.
 */
public class DriverTypeConverter implements Converter<DriverType> {

    /**
     * Converts a String to a DriverType enum.
     *
     * @param method The method that requires the conversion.
     * @param driverTypeStr The String representation of the driver type.
     * @return The corresponding DriverType enum.
     * @throws IllegalArgumentException if the input string is null, empty, or not a valid DriverType.
     */
    @Override
    public DriverType convert(Method method, String driverTypeStr) {
        if (driverTypeStr == null || driverTypeStr.isEmpty()) {
            throw new IllegalArgumentException("Driver type cannot be null or empty");
        }

        try {
            return DriverType.valueOf(driverTypeStr.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid driver type: " + driverTypeStr, e);
        }
    }
}
