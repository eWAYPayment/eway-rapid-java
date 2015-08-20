package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.ShippingAddress;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class TransactionToShippingAddressConverterTest {

    private BeanConverter<Transaction, ShippingAddress> convert;

    @Before
    public void setup() {
        convert = new TransactionShippingAddressConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        t.setShippingDetails(ObjectCreator.createShippingDetails());
        ShippingAddress address = convert.doConvert(t);
        Assert.assertEquals("Sydney", address.getCity());

    }

    @Test
    public void testNullShippingDetail() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        ShippingAddress address = convert.doConvert(t);
        Assert.assertNull(address.getCity());

    }

    @Test
    public void testNullAddress() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        t.setShippingDetails(ObjectCreator.createShippingDetails());
        t.getShippingDetails().setShippingAddress(null);
        ShippingAddress address = convert.doConvert(t);
        Assert.assertNull(address.getCity());

    }

    @After
    public void tearDown() {

    }
}
