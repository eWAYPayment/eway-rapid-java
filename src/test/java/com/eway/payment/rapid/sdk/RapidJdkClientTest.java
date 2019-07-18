package com.eway.payment.rapid.sdk;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.util.Constant;
import com.eway.payment.rapid.sdk.util.ResourceUtil;

public class RapidJdkClientTest {

    private RapidClient client;

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testValidRapidClientInputParam() {
        String APIKey = "skjskj";
        String passWord = "uncover";
        String endpoint = "https://api.sandbox.ewaypayments.com";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        List<String> listError = client.getErrors();
        assertTrue(client.isValid());
        assertTrue(listError.size() == 0);
    }

    @Test
    public void testInvalidRapidEndpoint() {
        String APIKey = "skjskj";
        String passWord = "uncover";
        String endpoint = "";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        List<String> listError = client.getErrors();
        assertTrue(!client.isValid());
        assertTrue(listError.size() == 1);
        for (String err : listError) {
            assertTrue(err
                    .equalsIgnoreCase(Constant.LIBRARY_NOT_HAVE_ENDPOINT_ERROR_CODE));
        }

    }

    @Test
    public void testMissingApiKeyOrPassword() {
        String APIKey = "skjskj";
        String passWord = "";
        String endpoint = "htttp://";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        List<String> listError = client.getErrors();
        assertTrue(!client.isValid());
        assertEquals(client.getErrors().size(), 1);
        for (String err : listError) {
            assertTrue(err
                    .equalsIgnoreCase(Constant.API_KEY_INVALID_ERROR_CODE));
        }
    }

    @Test
    public void testMissingApiKeyAndRapidEnpoint() {
        String APIKey = "skjskj";
        String passWord = "";
        String endpoint = "";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        List<String> listError = client.getErrors();
        assertTrue(!client.isValid());
        assertEquals(client.getErrors().size(), 2);
        assertTrue(listError
                .contains(Constant.LIBRARY_NOT_HAVE_ENDPOINT_ERROR_CODE));
        assertTrue(listError.contains(Constant.API_KEY_INVALID_ERROR_CODE));
    }

    @Test
    public void testInvalidSetCredential() {
        String APIKey = "skjskj";
        String passWord = "uncover";
        String endpoint = "https://api.sandbox.ewaypayments.com";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        assertTrue(client.isValid());
        String newAPIKey = "";
        String newPass = "uncover";
        client.setCredentials(newAPIKey, newPass);
        assertTrue(!client.isValid());
        assertEquals(client.getErrors().size(), 1);
        assertTrue(client.getErrors().contains(
                Constant.API_KEY_INVALID_ERROR_CODE));
    }

    @Test
    public void testInvalidWhenInstallClientButValidSetCredential() {
        String APIKey = "skjskj";
        String passWord = "";
        String endpoint = "https://api.sandbox.ewaypayments.com";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        assertTrue(!client.isValid());
        assertEquals(client.getErrors().size(), 1);
        String newAPIKey = "newAPIKey";
        String newPass = "uncover";
        client.setCredentials(newAPIKey, newPass);
        assertTrue(client.isValid());
        assertEquals(client.getErrors().size(), 0);
    }

    @Test
    public void testInitClientWithRapidEnpoinIsSandboxOrProduction()
            throws Exception {
        String APIKey = "skjskj";
        String passWord = "jjhhjk";
        String endpoint = "sandbox";
        client = RapidSDK.newRapidClient(APIKey, passWord, endpoint);
        Properties prop = ResourceUtil
                .loadProperies(Constant.RAPID_API_RESOURCE);
        Class<?> c = RapidClientImpl.class;
        Field field = c.getDeclaredField("webUrl");
        field.setAccessible(true);
        String value = (String) field.get(client);
        assertTrue(value.equalsIgnoreCase(prop
                .getProperty(Constant.GLOBAL_RAPID_SANDBOX_REST_URL_PARAM)));
        // Load properties file
    }

    @Test
    public void testFindErrorCode() throws Exception {
        String errCode = "S9991";
        assertEquals(
                "Library does not have an API key or password initialised, or are invalid",
                RapidSDK.userDisplayMessage(errCode, "en"));
    }

    @Test
    public void testNullErrorCode() {
        String errCode = null;
        assertEquals(
                null,
                RapidSDK.userDisplayMessage(errCode, "en"));
    }
}
