package com.eway.payment.rapid.sdk.integration.transaction;

import com.eway.payment.rapid.sdk.InputModelFactory;
import com.eway.payment.rapid.sdk.RapidClient;
import com.eway.payment.rapid.sdk.beans.external.*;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import com.eway.payment.rapid.sdk.integration.IntegrationTest;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;
import com.eway.payment.rapid.sdk.output.RefundResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CancelTransactionTest extends IntegrationTest {

    RapidClient client;
    Transaction t;
    Refund refund;

    @Before
    public void setup() {
        client = getSandboxClient();
        t = InputModelFactory.createTransaction();
        Customer c = InputModelFactory.initCustomer();
        Address a = InputModelFactory.initAddress();
        PaymentDetails p = InputModelFactory.initPaymentDetails();
        CardDetails cd = InputModelFactory.initCardDetails("12", "24");
        c.setCardDetails(cd);
        c.setAddress(a);
        t.setCustomer(c);
        t.setPaymentDetails(p);
        refund = new Refund();
        refund.setCustomer(c);

    }

    @Test
    public void testValidInput() {
        t.setCapture(false);
        CreateTransactionResponse res = client.create(PaymentMethod.Direct, t);
        RefundDetails rd = new RefundDetails();
        rd.setOriginalTransactionID(String.valueOf(res.getTransactionStatus().getTransactionID()));
        refund.setRefundDetails(rd);
        RefundResponse cancelRes = client.cancel(refund);
        Assert.assertTrue(cancelRes.getTransactionStatus().isStatus());
    }

    @Test
    public void testInvalidInput1() {
        RefundDetails rd = new RefundDetails();
        rd.setOriginalTransactionID("20400723");
        refund.setRefundDetails(rd);
        RefundResponse cancelRes = client.cancel(refund);
        Assert.assertTrue(cancelRes.getErrors().contains("V6134"));
    }

    @Test
    public void testInvalidInput2() {
        CreateTransactionResponse res = client.create(PaymentMethod.Direct, t);
        t.setAuthTransactionID(res.getTransactionStatus().getTransactionID());
        CreateTransactionResponse authRes = client.create(PaymentMethod.Authorisation, t);
        RefundDetails rd = new RefundDetails();
        rd.setOriginalTransactionID(String.valueOf(res.getTransactionStatus().getTransactionID()));
        refund.setRefundDetails(rd);
        RefundResponse cancelRes = client.cancel(refund);
        Assert.assertTrue(!cancelRes.getTransactionStatus().isStatus());
    }

    @After
    public void tearDown() {

    }

}
