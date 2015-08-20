package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.beans.internal.Transaction;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class InternalTransactionToStatusConverterTest {

    private BeanConverter<Transaction, TransactionStatus> convert;

    @Before
    public void setup() {
        convert = new InternalTransactionToStatusConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Transaction t = ObjectCreator.createInternalTransaction();
        TransactionStatus status = convert.doConvert(t);
        Assert.assertEquals(1000d, status.getTotal(), 0.001);
    }

    @Test(expected = ParameterInvalidException.class)
    public void testInvalidTransactionId() throws RapidSdkException {
        Transaction t = ObjectCreator.createInternalTransaction();
        t.setTransactionID("abc");
        convert.doConvert(t);
    }

    @After
    public void tearDown() {

    }
}
