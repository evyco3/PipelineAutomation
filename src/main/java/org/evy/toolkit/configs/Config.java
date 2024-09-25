package org.evy.toolkit.configs;

import org.aeonbits.owner.ConfigCache;

/**
 * Utility class for accessing configuration settings.
 * This class provides a static method to retrieve the configuration instance.
 */
public final class Config {

    // Private constructor to prevent instantiation
    private Config() {
    }

    /**
     * Retrieves the singleton instance of the ToolkitConfig.
     *
     * @return the ToolkitConfig instance
     */
    public static ToolkitConfig getConfig() {
        return ConfigCache.getOrCreate(ToolkitConfig.class);
    }
}
