package com.eway.payment.rapid.sdk.message.process.refund;

import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.beans.internal.RefundDetails;
import com.eway.payment.rapid.sdk.entities.CancelAuthorisationRequest;
import com.eway.payment.rapid.sdk.entities.CancelAuthorisationResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.ParameterInvalidException;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.response.CancelAuthorisationToRefundConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.RefundResponse;

import com.sun.jersey.api.client.WebResource;

public class CancelAuthorisationMsgProcess extends AbstractMakeRequestMessageProcess<Refund, RefundResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public CancelAuthorisationMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Refund refund) throws RapidSdkException {
        CancelAuthorisationRequest request = new CancelAuthorisationRequest();
        RefundDetails detail = refund.getRefundDetails();
        if (detail == null) {
            throw new ParameterInvalidException("Refund details are null");
        }
        request.setTransactionId(detail.getOriginalTransactionID());
        return request;
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        return doPost(req, CancelAuthorisationResponse.class);
    }

    @Override
    protected RefundResponse makeResult(Response res) throws RapidSdkException {
        BeanConverter<CancelAuthorisationResponse, RefundResponse> convert = new CancelAuthorisationToRefundConverter(getInput());
        return convert.doConvert((CancelAuthorisationResponse) res);
    }

}
