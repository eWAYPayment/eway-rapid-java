package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class TransactionToPaymentConverterTest {

    private BeanConverter<Transaction, Payment> convert;

    @Before
    public void setup() {
        convert = new TransactionToPaymentConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        t.setPaymentDetails(ObjectCreator.createPaymentDetails());
        Payment payment = convert.doConvert(t);
        Assert.assertEquals(1000d, payment.getTotalAmount(), 0.001);

    }

    @Test
    public void testNullPayment() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        Payment payment = convert.doConvert(t);
        Assert.assertEquals(0, payment.getTotalAmount());

    }

    @After
    public void tearDown() {

    }
}
