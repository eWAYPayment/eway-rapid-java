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
import com.eway.payment.rapid.sdk.beans.external.TransactionType;
import com.eway.payment.rapid.sdk.integration.IntegrationTest;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

public class ResponsiveTransactionTest extends IntegrationTest {

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
        t.setCustomView("bootstrap");
        t.setHeaderText("My Site Header Text");
        t.setCustomerReadOnly(false);
        t.setLogoUrl("https://mysite.com/images/logo4eway.jpg");
        t.setVerifyCustomerEmail(false);
        t.setVerifyCustomerPhone(false);
        t.setLanguage("EN");
        t.setCheckoutPayment(false);
    }

    @Test
    public void testValidInput() {
        CreateTransactionResponse res = client.create(PaymentMethod.ResponsiveShared, t);
        Assert.assertNotNull(res.getSharedPaymentUrl());
    }

    @Test
    public void testMinimalValidInput() {
        PaymentDetails paymentDetails = new PaymentDetails();
        paymentDetails.setTotalAmount(1000);

        Transaction transaction = new Transaction();
        transaction.setPaymentDetails(paymentDetails);
        transaction.setTransactionType(TransactionType.Purchase);
        transaction.setRedirectURL("http://www.eway.com.au");
        transaction.setCancelURL("http://www.eway.com.au");

        CreateTransactionResponse res = client.create(PaymentMethod.ResponsiveShared, transaction);
        Assert.assertNotNull(res.getSharedPaymentUrl());
    }

    @Test
    public void testBlankInput() {
        Transaction tran = new Transaction();
        Customer c = new Customer();
        CardDetails cd = new CardDetails();
        c.setCardDetails(cd);
        tran.setCustomer(c);
        tran.setTransactionType(TransactionType.Purchase);
        CreateTransactionResponse res = client.create(PaymentMethod.ResponsiveShared, tran);
        Assert.assertTrue(res.getErrors() != null && !res.getErrors().isEmpty());
    }

    @After
    public void tearDown() {

    }

}
