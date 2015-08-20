package com.eway.payment.rapid.sdk.message.process.transaction;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.entities.DirectPaymentRequest;
import com.eway.payment.rapid.sdk.entities.DirectPaymentResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.request.TransactionToDirectPaymentConverter;
import com.eway.payment.rapid.sdk.message.convert.response.DirectPaymentToCreateTransConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * Create transaction with direct payment message process
 */
public class TransDirectPaymentMsgProcess extends AbstractMakeRequestMessageProcess<Transaction, CreateTransactionResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public TransDirectPaymentMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Transaction input) throws RapidSdkException {
        BeanConverter<Transaction, DirectPaymentRequest> reqConverter = new TransactionToDirectPaymentConverter();
        return reqConverter.doConvert(input);
    }

    @Override
    protected CreateTransactionResponse makeResult(Response res) throws RapidSdkException {
        DirectPaymentResponse response = (DirectPaymentResponse) res;
        BeanConverter<DirectPaymentResponse, CreateTransactionResponse> converter = new DirectPaymentToCreateTransConverter();
        return converter.doConvert(response);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, DirectPaymentResponse.class);
    }

}
