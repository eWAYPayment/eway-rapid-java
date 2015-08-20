package com.eway.payment.rapid.sdk.message.convert;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.LineItem;
import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.object.create.ObjectCreator;

public class TransactionToArrLineItemConverterTest {

    private BeanConverter<Transaction, LineItem[]> convert;

    @Before
    public void setup() {
        convert = new TransactionToArrLineItemConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        t.setLineItems(ObjectCreator.createLineItems());
        LineItem[] itemArr = convert.doConvert(t);
        Assert.assertEquals(1, itemArr.length);
    }

    @Test
    public void testNullItem() throws RapidSdkException {
        Transaction t = ObjectCreator.createTransaction();
        LineItem[] itemArr = convert.doConvert(t);
        Assert.assertTrue(itemArr.length == 0);
    }

    @After
    public void tearDown() {

    }
}
