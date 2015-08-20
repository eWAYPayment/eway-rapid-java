package com.eway.payment.rapid.sdk.message.convert.request;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.CardDetails;
import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionType;
import com.eway.payment.rapid.sdk.entities.DirectPaymentRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class TransactionToDirectPaymentConverterTest {

    private BeanConverter<Transaction, DirectPaymentRequest> convert;
    Transaction input;

    @Before
    public void setup() {
        convert = new TransactionToDirectPaymentConverter();
        Customer customer = ObjectCreator.createExternalCustomer();
        Address address = ObjectCreator.createAddress();
        CardDetails cardDetails = ObjectCreator.createCardDetails();
        PaymentDetails paymentDetails = ObjectCreator.createPaymentDetails();
        input = new Transaction();
        customer.setAddress(address);
        customer.setCardDetails(cardDetails);
        input.setCustomer(customer);
        input.setPaymentDetails(paymentDetails);
        input.setTransactionType(TransactionType.Purchase);
        input.setCapture(true);
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        DirectPaymentRequest request = convert.doConvert(input);
        Assert.assertEquals(1000d, request.getPayment().getTotalAmount(), 0.001);
        Assert.assertEquals("John", request.getCustomer().getFirstName());
        Assert.assertEquals("Level 5", request.getCustomer().getStreet1());
        Assert.assertEquals("12", request.getCustomer().getCardDetails().getExpiryMonth());
        Assert.assertEquals(TransactionType.Purchase.name(), request.getTransactionType());

    }

    @After
    public void tearDown() {

    }
}
