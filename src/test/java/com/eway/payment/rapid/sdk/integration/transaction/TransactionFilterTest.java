package com.eway.payment.rapid.sdk.integration.transaction;

import org.apache.commons.lang3.StringUtils;
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
import com.eway.payment.rapid.sdk.beans.external.TransactionFilter;
import com.eway.payment.rapid.sdk.integration.IntegrationTest;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;

public class TransactionFilterTest extends IntegrationTest {

    private RapidClient client;
    private Transaction trans;

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
        CreateTransactionResponse transResponse = client.create(PaymentMethod.Direct, trans);
        Assert.assertTrue(transResponse.getTransactionStatus().isStatus());
        Assert.assertNotEquals(0, transResponse.getTransactionStatus().getTransactionID());

        TransactionFilter filter = new TransactionFilter();
        filter.setTransactionId(transResponse.getTransactionStatus().getTransactionID());

        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertTrue(res.getTransactionStatus().isStatus());
        Assert.assertEquals(transResponse.getTransactionStatus().getTransactionID(), res.getTransactionStatus().getTransactionID());
    }

    @Test
    public void testBlankInput() {
        TransactionFilter filter = new TransactionFilter();
        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertNull(res.getTransaction());
    }

    @Test
    public void testInvalidInput() {
        TransactionFilter filter = new TransactionFilter();
        filter.setTransactionId(11742962);
        filter.setInvoiceNumber("Inv 21540");
        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertTrue(res.getErrors().contains("S9991"));
    }

    @Test
    public void testSearchInvoiceNumberOrReference() {
        trans = InputModelFactory.createTransaction();
        Customer c = InputModelFactory.initCustomer();
        Address a = InputModelFactory.initAddress();
        String invoiceNum = InputModelFactory.randomString(10);
        String invoiceRef = InputModelFactory.randomString(10);
        PaymentDetails p = InputModelFactory.initPaymentDetails(invoiceNum, invoiceRef);
        CardDetails cd = InputModelFactory.initCardDetails("12", "24");
        c.setCardDetails(cd);
        c.setAddress(a);
        trans.setCustomer(c);
        trans.setPaymentDetails(p);
        CreateTransactionResponse transResponse = client.create(PaymentMethod.Direct, trans);
        Assert.assertTrue(transResponse.getTransactionStatus().isStatus());
        int transacionId = transResponse.getTransactionStatus().getTransactionID();

        // search invoice number
        TransactionFilter filter = new TransactionFilter();
        filter.setInvoiceNumber(invoiceNum);
        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertTrue(res.getTransactionStatus().isStatus());
        Assert.assertEquals(transacionId, res.getTransactionStatus().getTransactionID());
        Assert.assertEquals(invoiceNum, res.getTransaction().getPaymentDetails().getInvoiceNumber());
        // Search invoice  reference
        filter = new TransactionFilter();
        filter.setInvoiceReference(invoiceRef);
        res = client.queryTransaction(filter);
        Assert.assertTrue(res.getTransactionStatus().isStatus());
        Assert.assertEquals(transacionId, res.getTransactionStatus().getTransactionID());
        Assert.assertEquals(invoiceRef, res.getTransaction().getPaymentDetails().getInvoiceReference());

		// Search access code
    }

    @Test
    public void testSearchAccessCode() {
        trans = InputModelFactory.createTransaction();
        Customer c = InputModelFactory.initCustomer();
        Address a = InputModelFactory.initAddress();
        PaymentDetails p = InputModelFactory.initPaymentDetails();
        CardDetails cd = InputModelFactory.initCardDetails("12", "24");
        c.setCardDetails(cd);
        c.setAddress(a);
        trans.setCustomer(c);
        trans.setPaymentDetails(p);

        CreateTransactionResponse transResponse = client.create(PaymentMethod.TransparentRedirect, trans);
        String accessCode = transResponse.getAccessCode();
        Assert.assertTrue(!StringUtils.isBlank(accessCode));

        TransactionFilter filter = new TransactionFilter();
        filter.setAccessCode(accessCode);

        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertTrue(res.getErrors() == null || res.getErrors().isEmpty());

    }

    @Test
    public void testSearchMissingInvoiceNumber() {
        String invoiceNum = InputModelFactory.randomString(100);
        // search invoice number
        TransactionFilter filter = new TransactionFilter();
        filter.setInvoiceNumber(invoiceNum);
        QueryTransactionResponse res = client.queryTransaction(filter);
        Assert.assertTrue(res.getErrors() != null && !res.getErrors().isEmpty());
        Assert.assertTrue(res.getErrors().contains("V6171"));
    }

    @Test
    public void testMissingTransactionFilterObject() {
        // assign two field of transaction filter
        String invoiceNum = InputModelFactory.randomString(100);
        String invoiceRef = InputModelFactory.randomString(100);
        TransactionFilter filter = new TransactionFilter();
        filter.setInvoiceNumber(invoiceNum);
        filter.setInvoiceReference(invoiceRef);
        QueryTransactionResponse res = client.queryTransaction(filter);
        // expect error code null or empty and contain S9991: invalid parameter
        Assert.assertTrue(res.getErrors() != null && !res.getErrors().isEmpty());
    }

    @After
    public void tearDown() {

    }

}
