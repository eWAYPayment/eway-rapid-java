package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.entities.TransactionSearchResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.QueryTransactionResponse;

public class SearchToQueryTransConverterTest {

    private BeanConverter<TransactionSearchResponse, QueryTransactionResponse> convert;
    private TransactionSearchResponse response;

    @Before
    public void setup() throws Exception {
        convert = new SearchToQueryTransConverter();
        String escapedJson = "{\"Transactions\":[{\"AuthorisationCode\":\"607313\",\"ResponseCode\":\"00\",\"ResponseMessage\":\"A2000\",\"InvoiceNumber\":\"Inv 21540\",\"InvoiceReference\":\"513456\",\"TotalAmount\":1000,\"TransactionID\":11735670,\"TransactionStatus\":true,\"TokenCustomerID\":null,\"BeagleScore\":0,\"Options\":[],\"Verification\":{\"CVN\":0,\"Address\":0,\"Email\":0,\"Mobile\":0,\"Phone\":0},\"BeagleVerification\":{\"Email\":0,\"Phone\":0},\"Customer\":{\"TokenCustomerID\":null,\"Reference\":null,\"Title\":null,\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":null,\"JobDescription\":null,\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"Au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":null,\"Comments\":null,\"Fax\":null,\"Url\":null},\"CustomerNote\":null,\"ShippingAddress\":{\"ShippingMethod\":null,\"FirstName\":\"\",\"LastName\":\"\",\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"Country\":\"Au\",\"PostalCode\":\"2000\",\"Email\":\"\",\"Phone\":\"\",\"Fax\":null}}],\"Errors\":\"\"}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, TransactionSearchResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        QueryTransactionResponse res = convert.doConvert(response);
        Assert.assertEquals(1000d, res.getTransaction().getPaymentDetails().getTotalAmount(), 0.001);
        Assert.assertEquals(0d, res.getTransactionStatus().getBeagleScore(), 0.001);
    }

    @After
    public void tearDown() {

    }
}
