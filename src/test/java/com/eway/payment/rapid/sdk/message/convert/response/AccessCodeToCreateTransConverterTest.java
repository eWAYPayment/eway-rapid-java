package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.entities.CreateAccessCodeResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

public class AccessCodeToCreateTransConverterTest {

    private BeanConverter<CreateAccessCodeResponse, CreateTransactionResponse> convert;
    CreateAccessCodeResponse response;

    @Before
    public void setup() throws Exception {
        convert = new AccessCodeToCreateTransConverter();
        String escapedJson = "{\"AccessCode\":\"60CF3L9mWK-zQ9wxakOtyfjcBpNSRIngC2X2gudGR07jB7w_a8RgW6vp3YfmUCXK9cuywC8whzukY6TldEWlq0digXA_OOlwOr5rrUiHtL6EzruLWCQS-1byCuv_lgWz8hBMp\",\"Customer\":{\"CardNumber\":\"\",\"CardStartMonth\":\"\",\"CardStartYear\":\"\",\"CardIssueNumber\":\"\",\"CardName\":\"\",\"CardExpiryMonth\":\"\",\"CardExpiryYear\":\"\",\"IsActive\":false,\"TokenCustomerID\":null,\"Reference\":\"\",\"Title\":\"Mr.\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":\"Example\",\"JobDescription\":\"Java Developer\",\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":\"0123456789\",\"Comments\":\"\",\"Fax\":\"1234\",\"Url\":\"http://www.ewaypayments.com\"},\"Payment\":{\"TotalAmount\":1000,\"InvoiceNumber\":\"Inv 21540\",\"InvoiceDescription\":\"Individual Invoice Description\",\"InvoiceReference\":\"513456\",\"CurrencyCode\":\"AUD\"},\"FormActionURL\":\"https://secure-au.sandbox.ewaypayments.com/Process\",\"CompleteCheckoutURL\":null,\"Errors\":null}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, CreateAccessCodeResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        CreateTransactionResponse transRes = convert.doConvert(response);
        Assert.assertEquals(1000d, transRes.getTransaction().getPaymentDetails().getTotalAmount(), 0.001);
        Assert.assertEquals("John", transRes.getTransaction().getCustomer().getFirstName());
    }

    @After
    public void tearDown() {

    }
}
