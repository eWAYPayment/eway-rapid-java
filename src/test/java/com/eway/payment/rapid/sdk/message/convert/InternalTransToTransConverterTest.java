package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class InternalTransToTransConverterTest {

    private BeanConverter<com.eway.payment.rapid.sdk.beans.internal.Transaction, Transaction> convert;

    @Before
    public void setup() {
        convert = new InternalTransToTransConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        com.eway.payment.rapid.sdk.beans.internal.Transaction internalTran = ObjectCreator.createInternalTransaction();
        internalTran.setCustomer(ObjectCreator.createInternalCustomer());
        Transaction tran = convert.doConvert(internalTran);
        Assert.assertEquals("John", tran.getCustomer().getFirstName());
        Assert.assertEquals(1000d, tran.getPaymentDetails().getTotalAmount(), 0.001);
        Assert.assertEquals("Sydney", tran.getShippingDetails().getShippingAddress().getCity());
    }

    @After
    public void tearDown() {

    }
}
