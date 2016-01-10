package com.eway.payment.rapid.sdk.message.convert.request;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.Address;
import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.PaymentDetails;
import com.eway.payment.rapid.sdk.beans.external.RequestMethod;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.beans.external.TransactionType;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeRequest;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class TransactionToTransparentConverterTest {

    private BeanConverter<Transaction, CreateAccessCodeRequest> convert;
    Transaction input;

    @Before
    public void setup() {
        convert = new TransactionToCreateAccessCodeRequestConverter();
        Customer customer = ObjectCreator.createExternalCustomer();
        Address address = ObjectCreator.createAddress();
        PaymentDetails paymentDetails = ObjectCreator.createPaymentDetails();
        input = new Transaction();
        customer.setAddress(address);
        input.setCustomer(customer);
        input.setPaymentDetails(paymentDetails);
        input.setTransactionType(TransactionType.Purchase);
        input.setCapture(true);
        input.setRedirectURL("http://www.eway.com.au");
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        CreateAccessCodeRequest request = convert.doConvert(input);
        Assert.assertEquals(1000d, request.getPayment().getTotalAmount(), 0.001);
        Assert.assertEquals("John", request.getCustomer().getFirstName());
        Assert.assertEquals("Level 5", request.getCustomer().getStreet1());        
        Assert.assertEquals(TransactionType.Purchase.name(), request.getTransactionType());

    }
    
    @Test
    public void testDoConvertAuthorise() throws RapidSdkException {
        input.setCapture(false);
        CreateAccessCodeRequest request = convert.doConvert(input);
        Assert.assertEquals(1000d, request.getPayment().getTotalAmount(), 0.001);
        Assert.assertEquals("John", request.getCustomer().getFirstName());
        Assert.assertEquals("Level 5", request.getCustomer().getStreet1());        
        Assert.assertEquals(TransactionType.Purchase.name(), request.getTransactionType());
        Assert.assertEquals(RequestMethod.Authorise.name(), request.getMethod());

    }
    
    @Test
    public void testDoConvertSaveCustomer() throws RapidSdkException {
        input.setSaveCustomer(true);
        CreateAccessCodeRequest request = convert.doConvert(input);
        Assert.assertEquals(1000d, request.getPayment().getTotalAmount(), 0.001);
        Assert.assertEquals("John", request.getCustomer().getFirstName());
        Assert.assertEquals("Level 5", request.getCustomer().getStreet1());        
        Assert.assertEquals(TransactionType.Purchase.name(), request.getTransactionType());
        Assert.assertEquals(RequestMethod.TokenPayment.name(), request.getMethod());

    }

    @After
    public void tearDown() {

    }
}
