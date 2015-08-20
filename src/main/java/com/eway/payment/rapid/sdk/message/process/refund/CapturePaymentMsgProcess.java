package com.eway.payment.rapid.sdk.message.process.refund;

import com.eway.payment.rapid.sdk.beans.external.Transaction;
import com.eway.payment.rapid.sdk.entities.CapturePaymentRequest;
import com.eway.payment.rapid.sdk.entities.CapturePaymentResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.request.TransactionToCapturePaymentConverter;
import com.eway.payment.rapid.sdk.message.convert.response.CapturePaymentToCreateTransactionConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.CreateTransactionResponse;

import com.sun.jersey.api.client.WebResource;

/**
 * Capture payment message process
 */
public class CapturePaymentMsgProcess extends AbstractMakeRequestMessageProcess<Transaction, CreateTransactionResponse> {

    public CapturePaymentMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected CreateTransactionResponse makeResult(Response res) throws RapidSdkException {
        CapturePaymentResponse response = (CapturePaymentResponse) res;
        BeanConverter<CapturePaymentResponse, CreateTransactionResponse> convert = new CapturePaymentToCreateTransactionConverter();
        return convert.doConvert(response);
    }

    @Override
    protected Request createRequest(Transaction t) throws RapidSdkException {
        BeanConverter<Transaction, CapturePaymentRequest> converter = new TransactionToCapturePaymentConverter();
        return converter.doConvert(t);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, CapturePaymentResponse.class);
    }

}
