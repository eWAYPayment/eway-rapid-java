package com.eway.payment.rapid.sdk.message.process.transaction;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeRequest;
import com.eway.payment.rapid.sdk.entities.CreateAccessCodeResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.request.TransactionToCreateAccessCodeRequestConverter;
import com.eway.payment.rapid.sdk.message.convert.response.AccessCodeToCreateTransConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * Create transaction with transparent redirect method message process
 */
public class TransTransparentRedirectMsgProcess extends AbstractMakeRequestMessageProcess<Transaction, CreateTransactionResponse> {

    public TransTransparentRedirectMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Transaction input) throws RapidSdkException {
        BeanConverter<Transaction, CreateAccessCodeRequest> converter = new TransactionToCreateAccessCodeRequestConverter();
        return converter.doConvert(input);
    }

    @Override
    protected CreateTransactionResponse makeResult(Response res) throws RapidSdkException {
        CreateAccessCodeResponse response = (CreateAccessCodeResponse) res;
        BeanConverter<CreateAccessCodeResponse, CreateTransactionResponse> convert = new AccessCodeToCreateTransConverter();
        return convert.doConvert(response);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, CreateAccessCodeResponse.class);
    }

}
