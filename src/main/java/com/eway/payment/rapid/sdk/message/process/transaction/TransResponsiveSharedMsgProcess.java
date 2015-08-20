package com.eway.payment.rapid.sdk.message.process.transaction;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeSharedRequest;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeSharedResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.request.TransactionToCreateAccessCodeSharedRequestConverter;
import com.eway.payment.rapid.sdk.message.convert.response.AccessCodeSharedToCreateTransConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * Create transaction with responsive shared message process
 */
public class TransResponsiveSharedMsgProcess extends AbstractMakeRequestMessageProcess<Transaction, CreateTransactionResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public TransResponsiveSharedMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Transaction input) throws RapidSdkException {
        BeanConverter<Transaction, CreateAccessCodeSharedRequest> converter = new TransactionToCreateAccessCodeSharedRequestConverter();
        return converter.doConvert(input);
    }

    @Override
    protected CreateTransactionResponse makeResult(Response res) throws RapidSdkException {
        CreateAccessCodeSharedResponse response = (CreateAccessCodeSharedResponse) res;
        BeanConverter<CreateAccessCodeSharedResponse, CreateTransactionResponse> convert = new AccessCodeSharedToCreateTransConverter();
        return convert.doConvert(response);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, CreateAccessCodeSharedResponse.class);
    }

}
