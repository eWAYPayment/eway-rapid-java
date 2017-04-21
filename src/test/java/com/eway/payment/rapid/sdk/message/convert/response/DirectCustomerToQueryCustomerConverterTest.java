package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.entities.DirectCustomerSearchResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.QueryCustomerResponse;

public class DirectCustomerToQueryCustomerConverterTest {

    private BeanConverter<DirectCustomerSearchResponse, QueryCustomerResponse> convert;
    DirectCustomerSearchResponse response;
    DirectCustomerSearchResponse errorResponse;

    @Before
    public void setup() throws Exception {
        convert = new DirectCustomerToQueryCustomerConverter();
        String escapedJson = "{\"Customers\":[{\"CardDetails\":{\"Number\":\"444433XXXXXX1111\",\"Name\":\"John Smith\",\"ExpiryMonth\":\"12\",\"ExpiryYear\":\"25\",\"StartMonth\":\"\",\"StartYear\":\"\",\"IssueNumber\":\"\"},\"TokenCustomerID\":912981244527,\"Reference\":\"\",\"Title\":\"Mr.\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":\"Example\",\"JobDescription\":\"Java Developer\",\"Street1\":\"Level 5, 369 Queen Street\",\"Street2\":null,\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"Au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":\"0123456789\",\"Comments\":\"\",\"Fax\":\"1234\",\"Url\":\"http://www.ewaypayments.com\"}],\"Errors\":null}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        String escapedErrorJson = "{\"Customers\":[],\"Errors\":\"V6040\"}";
        String errorJson = StringEscapeUtils.unescapeJson(escapedErrorJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, DirectCustomerSearchResponse.class);
        errorResponse = mapper.readValue(errorJson, DirectCustomerSearchResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        QueryCustomerResponse customerRes = convert.doConvert(response);
        Assert.assertEquals("12", customerRes.getCardDetail().getExpiryMonth());
        Assert.assertEquals("John", customerRes.getFirstName());
        Assert.assertEquals("Sydney", customerRes.getCity());

    }

    @Test
    public void testError() throws RapidSdkException {
        QueryCustomerResponse customerRes = convert.doConvert(errorResponse);
        Assert.assertEquals("V6040", customerRes.getErrors().get(0));

    }

    @After
    public void tearDown() {

    }
}
