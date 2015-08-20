package com.eway.payment.rapid.sdk.message.convert.response;

import org.apache.commons.lang3.StringEscapeUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.eway.payment.rapid.sdk.beans.external.TransactionType;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

public class DirectPaymentToCreateTransConverterTest {

    private BeanConverter<DirectPaymentResponse, CreateTransactionResponse> convert;
    DirectPaymentResponse response;

    @Before
    public void setup() throws Exception {
        convert = new DirectPaymentToCreateTransConverter();
        String escapedJson = "{\"Errors\":null,\"AuthorisationCode\":\"843422\",\"ResponseCode\":\"00\",\"ResponseMessage\":\"A2000\",\"TransactionID\":11735584,\"TransactionStatus\":true,\"TransactionType\":\"Purchase\",\"BeagleScore\":0,\"Verification\":{\"CVN\":0,\"Address\":0,\"Email\":0,\"Mobile\":0,\"Phone\":0},\"Customer\":{\"CardDetails\":{\"Number\":\"444433XXXXXX1111\",\"Name\":\"John Smith\",\"ExpiryMonth\":\"12\",\"ExpiryYear\":\"25\",\"StartMonth\":null,\"StartYear\":null,\"IssueNumber\":null},\"TokenCustomerID\":null,\"Reference\":\"\",\"Title\":\"Mr.\",\"FirstName\":\"John\",\"LastName\":\"Smith\",\"CompanyName\":\"Example\",\"JobDescription\":\"Java Developer\",\"Street1\":\"Level 5\",\"Street2\":\"369 Queen Street\",\"City\":\"Sydney\",\"State\":\"NSW\",\"PostalCode\":\"2000\",\"Country\":\"Au\",\"Email\":\"\",\"Phone\":\"0123456789\",\"Mobile\":\"0123456789\",\"Comments\":\"\",\"Fax\":\"1234\",\"Url\":\"http://www.ewaypayments.com\"},\"Payment\":{\"TotalAmount\":1000,\"InvoiceNumber\":\"Inv 21540\",\"InvoiceDescription\":\"Individual Invoice Description\",\"InvoiceReference\":\"513456\",\"CurrencyCode\":\"AUD\"}}";
        String json = StringEscapeUtils.unescapeJson(escapedJson);
        ObjectMapper mapper = new ObjectMapper();

        response = mapper.readValue(json, DirectPaymentResponse.class);

    }

    @Test
    public void testDoConvert() throws RapidSdkException {
        CreateTransactionResponse transRes = convert.doConvert(response);
        Assert.assertEquals(TransactionType.Purchase, transRes.getTransaction().getTransactionType());
        Assert.assertEquals(1000d, transRes.getTransaction().getPaymentDetails().getTotalAmount(), 0.001);
        Assert.assertEquals("John", transRes.getTransaction().getCustomer().getFirstName());
        Assert.assertEquals("843422", transRes.getTransactionStatus().getProcessingDetails().getAuthorisationCode());
    }

    @After
    public void tearDown() {

    }
}
