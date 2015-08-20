package com.eway.payment.rapid.sdk;

import com.eway.payment.rapid.sdk.util.Constant;
import com.eway.payment.rapid.sdk.util.ResourceUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

/**
 * The eWAY RapidSDK client factory.
 * Use to create a new instance of the RapidClient and to translate messages to
 * their user friendly equivalent.
 * 
 * Example:
 * <pre>
 * {@code
 * String APIKEY = "API Key";
 * String PASSWORD = "Password";
 * String RAPID_ENDPOINT = "Sandbox";
 * RapidClient client = RapidSDK.newRapidClient(APIKEY, PASSWORD, RAPID_ENDPOINT);
 * }
 * </pre>
 * 
 * @author eWAY
 */
public class RapidSDK {

    private static final Logger LOGGER = LoggerFactory.getLogger(RapidSDK.class);

    /**
     * Creates new instance of Rapid Client
     *
     * @param APIKey Rapid API Key
     * @param password Rapid API Password
     * @param rapidEndpoint Rapid API endpoint, one of "Production", "Sandbox" 
     *  or a URL
     * @return A Rapid Client
     */
    public static RapidClient newRapidClient(String APIKey, String password, String rapidEndpoint) {
        return new RapidClientImpl(APIKey, password, rapidEndpoint);
    }

    /**
     * Translate an error code to a user friendly message
     *
     * @param code The eWAY error code to translate
     * @param language The language to use e.g. "en" (only en available at this
     * time)
     * @return User friendly error message, {@code null} if not found
     */
    public static String userDisplayMessage(String code, String language) {
        return findErrorCode(code);
    }

    /**
     * Find the error code in properties file
     *
     * @param code The eWAY error code to find
     * @return The user friendly message, or {@code null} if not found
     */
    private static String findErrorCode(String code) {
        Properties prop;
        try {
            prop = ResourceUtil.loadProperiesOnResourceFolder(Constant.ERROR_CODE_RESOURCE_EN);
            return prop.getProperty(code);
        } catch (Exception e) {
            LOGGER.error("Load resource from file:" + Constant.ERROR_CODE_RESOURCE_EN + " error", e);
            return null;
        }
    }

}
