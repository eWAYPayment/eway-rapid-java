package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class PaymentToPaymentDetailConverterTest {

    private BeanConverter<Payment, PaymentDetails> convert;

    @Before
    public void setup() {
        convert = new PaymentToPaymentDetailsConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Payment payment = ObjectCreator.createPayment();
        PaymentDetails paymentDetails = convert.doConvert(payment);
        Assert.assertEquals(1000d, paymentDetails.getTotalAmount(), 0.001);
    }

    @Test
    public void testNullPayment() throws RapidSdkException {
        PaymentDetails paymentDetails = convert.doConvert(null);
        Assert.assertEquals(0, paymentDetails.getTotalAmount());
    }

    @After
    public void tearDown() {

    }
}
