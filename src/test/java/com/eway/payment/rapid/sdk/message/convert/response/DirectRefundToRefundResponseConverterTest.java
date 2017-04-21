package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.entities.DirectRefundResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.RefundResponse;

public class DirectRefundToRefundResponseConverterTest {

    private BeanConverter<DirectRefundResponse, RefundResponse> convert;
    DirectRefundResponse response;

    @Before
    public void setup() throws Exception {
        convert = new DirectRefundToRefundResponseConverter();
        String escapedJson = "{\"AuthorisationCode\":\"480233\",\"ResponseCode\":null,\"ResponseMessage\":\"A2000\",\"TransactionID\":11735642,\"TransactionStatus\":true,\"Verification\":null,\"Customer\":{\"CardDetails\":{\"Number\":\"\",\"Name\":\"\",\"ExpiryMonth\":\"12\",\"ExpiryYear\":\"25\",\"StartMonth\":\"\",\"StartYear\":\"\",\"IssueNumber\":\"\"},\"TokenCustomerID\":null,\"Reference\":\"\",\"Title\":\"Mr.\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":\"Example\",\"JobDescription\":\"Java Developer\",\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":\"0123456789\",\"Comments\":\"\",\"Fax\":\"1234\",\"Url\":\"http://www.ewaypayments.com\"},\"Refund\":{\"TransactionID\":\"11735641\",\"TotalAmount\":1000,\"InvoiceNumber\":\"Inv 21540\",\"InvoiceDescription\":\"Individual Invoice Description\",\"InvoiceReference\":\"513456\",\"CurrencyCode\":\"AUD\"},\"Errors\":null}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, DirectRefundResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        RefundResponse res = convert.doConvert(response);
        Assert.assertEquals(1000d, res.getRefund().getRefundDetails().getTotalAmount(), 0.001);
        Assert.assertEquals("John", res.getRefund().getCustomer().getFirstName());
        Assert.assertEquals("12", res.getRefund().getCustomer().getCardDetails().getExpiryMonth());
    }

    @After
    public void tearDown() {

    }
}
