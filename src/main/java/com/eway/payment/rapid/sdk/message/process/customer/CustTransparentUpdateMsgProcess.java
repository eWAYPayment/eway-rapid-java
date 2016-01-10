package com.eway.payment.rapid.sdk.message.process.customer;

import com.eway.payment.rapid.sdk.beans.external.Customer;
import com.eway.payment.rapid.sdk.beans.external.TransactionType;
import com.eway.payment.rapid.sdk.beans.internal.Payment;
import com.eway.payment.rapid.sdk.entities.*;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.CustomerToInternalCustomerConverter;
import com.eway.payment.rapid.sdk.message.convert.response.AccessCodeToCreateCustConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.util.Constant;
import com.sun.jersey.api.client.WebResource;

/**
 * Update customer with transparent redirect message process
 */
public class CustTransparentUpdateMsgProcess extends AbstractMakeRequestMessageProcess<Customer, CreateCustomerResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public CustTransparentUpdateMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Customer input) throws RapidSdkException {
        CreateAccessCodeRequest request = new CreateAccessCodeRequest();
        CustomerToInternalCustomerConverter interCustConvert = new CustomerToInternalCustomerConverter();
        Payment payment = new Payment();
        payment.setTotalAmount(0);
        request.setPayment(payment);
        request.setCustomer(interCustConvert.doConvert(input));
        request.setMethod(Constant.UPDATE_TOKEN_CUSTOMER_METHOD);
        request.setTransactionType(TransactionType.Purchase.name());
        request.setRedirectUrl(input.getRedirectUrl());
        return request;
    }

    @Override
    protected CreateCustomerResponse makeResult(Response res) {
        CreateAccessCodeResponse response = (CreateAccessCodeResponse) res;
        AccessCodeToCreateCustConverter converter = new AccessCodeToCreateCustConverter();
        return converter.doConvert(response);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, CreateAccessCodeResponse.class);
    }

}
