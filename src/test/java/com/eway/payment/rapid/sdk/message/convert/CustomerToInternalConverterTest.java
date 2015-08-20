package com.eway.payment.rapid.sdk.message.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.InputModelFactory;
import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.external.Customer;

public class CustomerToInternalConverterTest {

    private CustomerToInternalCustomerConverter convert;

    @Before
    public void setup() {
        convert = new CustomerToInternalCustomerConverter();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void testConvertCustomerCardDetail() throws Exception {
        Customer cust = InputModelFactory.initCustomer();
        cust.setCardDetails(InputModelFactory.initCardDetails("12", "25"));
        com.eway.payment.rapid.sdk.beans.internal.Customer interCust = convert.doConvert(cust);
        CardDetails detail = interCust.getCardDetails();
        assertNotNull(detail);
        assertNotNull(detail.getExpiryMonth());
        assertNotNull(detail.getExpiryYear());
        assertEquals("12", detail.getExpiryMonth());
        assertEquals("25", detail.getExpiryYear());
    }

    @Test
    public void testConvertCustomerAddress() throws Exception {
        Customer cust = InputModelFactory.initCustomer();
        String city = "Sydney";
        String postalCode = "084";
        String state = "NSW";
        String country = "Autralia";
        Address add = InputModelFactory.createAddress(city, country, postalCode, state);
        cust.setAddress(add);
        com.eway.payment.rapid.sdk.beans.internal.Customer interCust = convert.doConvert(cust);
        assertNotNull(interCust.getState());
        assertEquals(city, interCust.getCity());
        assertNotNull(interCust.getCountry());
        assertEquals(city, interCust.getCity());
        assertNotNull(interCust.getCity());
        assertEquals(city, interCust.getCity());
        assertNotNull(interCust.getPostalCode());
        assertEquals(postalCode, interCust.getPostalCode());
    }

    @Test
    public void testConvertCustomerWithoutAddress() throws Exception {
        Customer cust = InputModelFactory.initCustomer();
        com.eway.payment.rapid.sdk.beans.internal.Customer interCust = convert.doConvert(cust);
        assertNull(interCust.getState());
        assertNull(interCust.getCity());
        assertNull(interCust.getCountry());
        assertNull(interCust.getPostalCode());
    }

}
