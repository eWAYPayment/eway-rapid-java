package com.eway.payment.rapid.sdk.message.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.FraudAction;
import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.beans.internal.Verification;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class DirectPaymentToTransStatusConverterTest {

    private DirectPaymentToTransStatusConverter convert;

    @Before
    public void setup() {
        convert = new DirectPaymentToTransStatusConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        DirectPaymentResponse response = new DirectPaymentResponse();
        response.setTransactionID("123456");
        response.setBeagleScore(0d);
        response.setFraudAction(FraudAction.Allow.name());
        response.setTransactionCaptured("true");
        // response.setAuthorisationCode("1234");
        // response.setResponseCode("200");
        // response.setResponseMessage("A2000");
        response.setTransactionStatus(true);
        Payment payment = ObjectCreator.createPayment();
        response.setPayment(payment);
        Verification verification = ObjectCreator.createVerification();
        response.setVerification(verification);
        TransactionStatus status = convert.doConvert(response);
        assertEquals(response.getBeagleScore(), 0d, 0.001);
        assertEquals(FraudAction.Allow, status.getFraudAction());
        assertTrue(status.isCaptured());
    }

    @Test(expected = ParameterInvalidException.class)
    public void testInvalidTransactionId() throws RapidSdkException {
        DirectPaymentResponse response = new DirectPaymentResponse();
        response.setTransactionID("abcd");
        Payment payment = ObjectCreator.createPayment();
        response.setPayment(payment);
        convert.doConvert(response);
    }

    @Test
    public void testInvalidVerification() throws RapidSdkException {
        DirectPaymentResponse response = new DirectPaymentResponse();
        response.setTransactionID("1234");
        Payment payment = ObjectCreator.createPayment();
        response.setPayment(payment);
        Verification verification = ObjectCreator.createVerification();
        verification.setAddress("a");
        response.setVerification(verification);
        convert.doConvert(response);
    }

    @After
    public void tearDown() {

    }
}
