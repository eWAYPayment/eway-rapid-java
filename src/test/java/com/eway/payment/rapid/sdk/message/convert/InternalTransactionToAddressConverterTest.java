package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.internal.Transaction;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class InternalTransactionToAddressConverterTest {

    private BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Transaction, Address> convert;

    @Before
    public void setup() {
        convert = new InternalTransactionToAddressConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Transaction t = ObjectCreator.createInternalTransaction();
        Address address = convert.doConvert(t);
        Assert.assertEquals("Sydney", address.getCity());
    }

    @After
    public void tearDown() {

    }
}
