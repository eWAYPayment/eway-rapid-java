package com.eway.payment.rapid.sdk.message.convert;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.TransactionStatus;
import com.eway.payment.rapid.sdk.entities.DirectRefundResponse;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;

public class DirectRefundToTransStatusConverterTest {

    private BeanConverter<DirectRefundResponse, TransactionStatus> convert;

    @Before
    public void setup() {
        convert = new DirectRefundToTransStatusConverter();
    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        DirectRefundResponse response = new DirectRefundResponse();
        response.setTransactionID("123456");
        response.setTransactionStatus(new Boolean(true));
        TransactionStatus status = convert.doConvert(response);
        assertEquals(123456, status.getTransactionID());
        assertTrue(status.isStatus());
    }

    @Test(expected = ParameterInvalidException.class)
    public void testInvalidTransactionId() throws RapidSdkException {
        DirectRefundResponse response = new DirectRefundResponse();
        response.setTransactionID("abcd");
        convert.doConvert(response);
    }

    @After
    public void tearDown() {

    }
}
