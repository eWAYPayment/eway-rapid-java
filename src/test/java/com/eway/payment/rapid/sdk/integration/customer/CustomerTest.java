package com.eway.payment.rapid.sdk.integration.customer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Field;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Test;

import com.eway.payment.rapid.sdk.InputModelFactory;
import com.eway.payment.rapid.sdk.RapidClient;
import com.eway.payment.rapid.sdk.RapidSDK;
import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentMethod;
import com.eway.payment.rapid.sdk.entities.CreateCustomerResponse;
import com.eway.payment.rapid.sdk.integration.IntegrationTest;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;
import com.eway.payment.rapid.sdk.util.Constant;

public class CustomerTest extends IntegrationTest {

    @Test
    public void testCreateCustomerDirect() throws Exception {
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        cust.setAddress(address);
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.Direct, cust);
        Customer createCust = response.getCustomer();
        assertEquals(cust.getFirstName(), createCust.getFirstName());
    }

    @Test
    public void testCreateCustomerDirectButAuthenFailure() throws Exception {
        RapidClient client = RapidSDK.newRapidClient(APIKEY, "ABCXYZ", SANDBOX_ENDPOINT);
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        cust.setAddress(address);
        CreateCustomerResponse response = client.create(PaymentMethod.Direct, cust);
        assertTrue(!response.getErrors().isEmpty());
        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(Constant.AUTHENTICATION_FAILURE_ERROR_CODE));
    }

    @Test
    public void testCreateCustomerDirectButWrongEndpoint() throws Exception {
        String invalidEndpoint = "https://api.sandbox.ewaypayments.com";
        RapidClient client = RapidSDK.newRapidClient(APIKEY, "ABCXYZ", invalidEndpoint);
        String fakeWebUrl = "https://hhhhhhh.ggg";
        // Change invalid url
        Class<?> c = client.getClass();
        Field f = c.getDeclaredField("webUrl");
        f.setAccessible(true);
        f.set(client, fakeWebUrl);
        // Test
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        cust.setAddress(address);
        CreateCustomerResponse response = client.create(PaymentMethod.Direct, cust);
        assertTrue(!response.getErrors().isEmpty());
        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(Constant.COMMUNICATION_FAILURE_ERROR_CODE));
    }

    @Test
    public void testCreateCustomerInvalidPaymentMethod() throws Exception {
        Customer cust = ObjectCreator.createExternalCustomer();
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.Wallet, cust);
        assertTrue(!response.getErrors().isEmpty());
        assertEquals(1, response.getErrors().size());
        assertTrue(response.getErrors().contains(Constant.INTERNAL_RAPID_API_ERROR_CODE));
    }

    @Test
    public void testCreateCustomerWithBlankInput() throws Exception {
        Customer cust = InputModelFactory.initCustomer();
        Address address = new Address();
        cust.setAddress(address);
        CardDetails detail = new CardDetails();
        cust.setCardDetails(detail);
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.Direct, cust);
        assertTrue(!response.getErrors().isEmpty());
        String[] errorCode = {"V6021", "V6022", "V6101", "V6102"};
        for (String errCheck : errorCode) {
            assertTrue(response.getErrors().contains(errCheck));
        }
    }

    @Test
    public void testQueryDirectValidCustomerId() {
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        cust.setAddress(address);
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.Direct, cust);
        String tokenCustomerId = response.getCustomer().getTokenCustomerID();
        assertNotNull(tokenCustomerId);
        long tokenId = Long.parseLong(tokenCustomerId);
        QueryCustomerResponse custResponse = getSandboxClient().queryCustomer(tokenId);
        List<String> listError = custResponse.getErrors();
        assertTrue(listError == null || listError.isEmpty());
    }

    @Test
    public void testCreateCustomerWithResponseShared() {
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        cust.setAddress(address);
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.ResponsiveShared, cust);
        assertTrue(!StringUtils.isBlank(response.getSharedPaymentUrl()));
    }

    @Test
    public void testCreateCustomerWithTransparentReDirect() {
        Customer cust = InputModelFactory.initCustomer();
        Address address = InputModelFactory.initAddress();
        cust.setAddress(address);
        CardDetails detail = InputModelFactory.initCardDetails("12", "25");
        cust.setCardDetails(detail);
        CreateCustomerResponse response = getSandboxClient().create(PaymentMethod.TransparentRedirect, cust);
        assertTrue(!StringUtils.isBlank(response.getFormActionUrl()));
    }

    @After
    public void tearDown() {

    }
}
