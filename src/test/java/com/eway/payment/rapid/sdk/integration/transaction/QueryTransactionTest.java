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
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;

public class QueryTransactionTest extends IntegrationTest {

    RapidClient client;
    Transaction trans;

    @Before
    public void setup() {
        client = getSandboxClient();

    }

    @Test
    public void testValidInput() {
        trans = InputModelFactory.createTransaction();
        Customer c = InputModelFactory.initCustomer();
        Address a = InputModelFactory.initAddress();
        PaymentDetails p = InputModelFactory.initPaymentDetails();
        CardDetails cd = InputModelFactory.initCardDetails("12", "24");
        c.setCardDetails(cd);
        c.setAddress(a);
        trans.setCustomer(c);
        trans.setPaymentDetails(p);

        CreateTransactionResponse transResponse = client.create(
                PaymentMethod.Direct, trans);
        Assert.assertTrue(transResponse.getTransactionStatus().isStatus());
        Assert.assertNotEquals(0, transResponse.getTransactionStatus()
                .getTransactionID());

        int transactionId = transResponse.getTransactionStatus()
                .getTransactionID();
        QueryTransactionResponse query = client.queryTransaction(transactionId);
        Assert.assertEquals(transactionId, query.getTransactionStatus()
                .getTransactionID());
        Assert.assertFalse(query.getTransaction().getOptions().isEmpty());
        Assert.assertTrue(query.getErrors() == null || query.getErrors().isEmpty());

    }

    @Test
    public void testBlankInput() {
        QueryTransactionResponse res = client.queryTransaction("");
        Assert.assertNull(res.getTransaction());
    }

    @Test
    public void testInvalidInput() {
        QueryTransactionResponse res = client
                .queryTransaction(InputModelFactory.randomString(50));
        Assert.assertNull(res.getTransaction());
    }

    @After
    public void tearDown() {

    }

}
