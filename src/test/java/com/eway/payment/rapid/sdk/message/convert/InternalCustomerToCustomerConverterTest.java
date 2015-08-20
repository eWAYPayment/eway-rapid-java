package com.eway.payment.rapid.sdk.message.convert;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class InternalCustomerToCustomerConverterTest {

    private BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Customer, Customer> convert;

    @Before
    public void init() {
        convert = new InternalCustomerToCustomerConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        com.eway.payment.rapid.sdk.beans.internal.Customer internalCustomer = ObjectCreator.createInternalCustomer();
        Customer customer = convert.doConvert(internalCustomer);
        assertEquals("John", customer.getFirstName());
        assertEquals("12", customer.getCardDetails().getExpiryMonth());

    }

    @After
    public void tearDown() {

    }
}
