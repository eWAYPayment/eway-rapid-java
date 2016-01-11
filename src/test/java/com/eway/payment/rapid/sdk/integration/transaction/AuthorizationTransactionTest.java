package com.eway.payment.rapid.sdk.integration.transaction;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.InputModelFactory;
import com.eway.payment.rapid.sdk.RapidClient;
import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.external.PaymentMethod;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.integration.IntegrationTest;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

public class AuthorizationTransactionTest extends IntegrationTest {

    RapidClient client;
    Transaction t;

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
    }

    @Test
    public void testValidInput() {
        CreateTransactionResponse res = client.create(PaymentMethod.Direct, t);
        t.setAuthTransactionID(res.getTransactionStatus().getTransactionID());
        CreateTransactionResponse authRes = client.create(PaymentMethod.Authorisation, t);
        Assert.assertTrue(res.getTransactionStatus().isStatus());
        Assert.assertNotEquals(0, authRes.getTransactionStatus().getTransactionID());
    }

    @Test
    public void testInvalidInput1() {
        t.setAuthTransactionID(1234);
        CreateTransactionResponse authRes = client.create(PaymentMethod.Authorisation, t);
        Assert.assertTrue(authRes.getErrors().get(0).contains("V6134"));
    }

    @Test
    public void testInvalidInput2() {
        CreateTransactionResponse res = client.create(PaymentMethod.Direct, t);
        t.setAuthTransactionID(res.getTransactionStatus().getTransactionID());
        CreateTransactionResponse authRes = client.create(PaymentMethod.Authorisation, t);
        CreateTransactionResponse authRes2 = client.create(PaymentMethod.Authorisation, t);
        Assert.assertTrue(!authRes2.getTransactionStatus().isStatus());
    }

    @After
    public void tearDown() {

    }

}
