package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.entities.CreateCustomerResponse;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;

public class DirectPaymentToCreateCustConverterTest {

    private BeanConverter<DirectPaymentResponse, CreateCustomerResponse> convert;
    DirectPaymentResponse response;

    @Before
    public void setup() throws Exception {
        convert = new DirectPaymentToCreateCustConverter();
        String escapedJson = "{\"AuthorisationCode\":null,\"ResponseCode\":\"00\",\"ResponseMessage\":\"A2000\",\"TransactionID\":null,\"TransactionStatus\":false,\"TransactionType\":\"Purchase\",\"BeagleScore\":null,\"Verification\":{\"CVN\":0,\"Address\":0,\"Email\":0,\"Mobile\":0,\"Phone\":0},\"Customer\":{\"CardDetails\":{\"Number\":\"444433XXXXXX1111\",\"Name\":\"John Smith\",\"ExpiryMonth\":\"12\",\"ExpiryYear\":\"25\",\"StartMonth\":null,\"StartYear\":null,\"IssueNumber\":null},\"TokenCustomerID\":913079262890,\"Reference\":\"\",\"Title\":\"Mr.\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":\"Example\",\"JobDescription\":\"Java Developer\",\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"Au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":\"0123456789\",\"Comments\":\"\",\"Fax\":\"1234\",\"Url\":\"http://www.ewaypayments.com\"},\"Payment\":{\"TotalAmount\":0,\"InvoiceNumber\":\"\",\"InvoiceDescription\":\"\",\"InvoiceReference\":\"\",\"CurrencyCode\":\"AUD\"},\"Errors\":null}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, DirectPaymentResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        CreateCustomerResponse customerRes = convert.doConvert(response);
        Assert.assertEquals("John", customerRes.getCustomer().getFirstName());
        Assert.assertEquals("Level 5", customerRes.getCustomer().getAddress().getStreet1());
        Assert.assertEquals("12", customerRes.getCustomer().getCardDetails().getExpiryMonth());

    }

    @After
    public void tearDown() {

    }
}
