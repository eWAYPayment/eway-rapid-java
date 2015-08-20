package com.eway.payment.rapid.sdk.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Class to handle loading properties from the properties file
 */
public class ResourceUtil {

    /**
     * Load properties resource with default resource path in resource coding
     * folder
     *
     * @param fileName Name of file resource
     * @return Map of resource attributes
     * @throws Exception An error that occurs when loading file resource fails
     */
    public static Properties loadProperiesOnResourceFolder(String fileName) throws Exception {
        return loadProperies(fileName);

    }

    /**
     * Load properties from the given file name and file path
     *
     * @param fileName Name of file resource
     * @return Map of resource attribute
     * @throws Exception An error that occurs when loading file resource fails
     */
    public static Properties loadProperies(String fileName) throws Exception {
        Properties prop = new Properties();
        InputStream input = ResourceUtil.class.getClassLoader().getResourceAsStream(fileName);
        prop.load(input);
        return prop;
    }

}
