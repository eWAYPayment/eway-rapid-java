package com.eway.payment.rapid.sdk.message.process.refund;

import com.eway.payment.rapid.sdk.beans.external.Refund;
import com.eway.payment.rapid.sdk.entities.DirectRefundRequest;
import com.eway.payment.rapid.sdk.entities.DirectRefundResponse;
import com.eway.payment.rapid.sdk.entities.Request;
import com.eway.payment.rapid.sdk.entities.Response;
import com.eway.payment.rapid.sdk.exception.RapidSdkException;
import com.eway.payment.rapid.sdk.message.convert.BeanConverter;
import com.eway.payment.rapid.sdk.message.convert.request.RefundToDirectRefundReqConverter;
import com.eway.payment.rapid.sdk.message.convert.response.DirectRefundToRefundResponseConverter;
import com.eway.payment.rapid.sdk.message.process.AbstractMakeRequestMessageProcess;
import com.eway.payment.rapid.sdk.output.RefundResponse;
import com.eway.payment.rapid.sdk.util.Constant;

import com.sun.jersey.api.client.WebResource;

/**
 * Refund message process
 */
public class RefundMsgProcess extends AbstractMakeRequestMessageProcess<Refund, RefundResponse> {

    /**
     * @param resource The web resource to call Rapid API
     * @param requestPath Path of request URL. Used to make full web service URL
     */
    public RefundMsgProcess(WebResource resource, String... requestPath) {
        super(resource, requestPath);
    }

    @Override
    protected Request createRequest(Refund refund) throws RapidSdkException {
        BeanConverter<Refund, DirectRefundRequest> reqConverter = new RefundToDirectRefundReqConverter();
        return reqConverter.doConvert(refund);
    }

    @Override
    protected Response sendRequest(Request req) throws RapidSdkException {
        DirectRefundRequest request = (DirectRefundRequest) req;
        addRequestPath(request.getRefund().getOriginalTransactionID(), Constant.REFUND_SUBPATH_METHOD);
        return doPost(request, DirectRefundResponse.class);
    }

    @Override
    protected RefundResponse makeResult(Response res) throws RapidSdkException {
        DirectRefundResponse response = (DirectRefundResponse) res;
        BeanConverter<DirectRefundResponse, RefundResponse> responseConvert = new DirectRefundToRefundResponseConverter();
        return responseConvert.doConvert(response);
    }

}
